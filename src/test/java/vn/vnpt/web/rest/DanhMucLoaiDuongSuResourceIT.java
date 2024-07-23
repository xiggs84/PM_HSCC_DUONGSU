package vn.vnpt.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static vn.vnpt.domain.DanhMucLoaiDuongSuAsserts.*;
import static vn.vnpt.web.rest.TestUtil.createUpdateProxyForBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import vn.vnpt.IntegrationTest;
import vn.vnpt.domain.DanhMucLoaiDuongSu;
import vn.vnpt.repository.DanhMucLoaiDuongSuRepository;
import vn.vnpt.service.dto.DanhMucLoaiDuongSuDTO;
import vn.vnpt.service.mapper.DanhMucLoaiDuongSuMapper;

/**
 * Integration tests for the {@link DanhMucLoaiDuongSuResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class DanhMucLoaiDuongSuResourceIT {

    private static final Long DEFAULT_ID_LOAI_DS = 1L;
    private static final Long UPDATED_ID_LOAI_DS = 2L;

    private static final String DEFAULT_DIEN_GIAI = "AAAAAAAAAA";
    private static final String UPDATED_DIEN_GIAI = "BBBBBBBBBB";

    private static final Long DEFAULT_TRANG_THAI = 1L;
    private static final Long UPDATED_TRANG_THAI = 2L;

    private static final String DEFAULT_STR_SEARCH = "AAAAAAAAAA";
    private static final String UPDATED_STR_SEARCH = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/danh-muc-loai-duong-sus";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private DanhMucLoaiDuongSuRepository danhMucLoaiDuongSuRepository;

    @Autowired
    private DanhMucLoaiDuongSuMapper danhMucLoaiDuongSuMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDanhMucLoaiDuongSuMockMvc;

    private DanhMucLoaiDuongSu danhMucLoaiDuongSu;

    private DanhMucLoaiDuongSu insertedDanhMucLoaiDuongSu;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DanhMucLoaiDuongSu createEntity(EntityManager em) {
        DanhMucLoaiDuongSu danhMucLoaiDuongSu = new DanhMucLoaiDuongSu()
            .idLoaiDs(DEFAULT_ID_LOAI_DS)
            .dienGiai(DEFAULT_DIEN_GIAI)
            .trangThai(DEFAULT_TRANG_THAI)
            .strSearch(DEFAULT_STR_SEARCH);
        return danhMucLoaiDuongSu;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DanhMucLoaiDuongSu createUpdatedEntity(EntityManager em) {
        DanhMucLoaiDuongSu danhMucLoaiDuongSu = new DanhMucLoaiDuongSu()
            .idLoaiDs(UPDATED_ID_LOAI_DS)
            .dienGiai(UPDATED_DIEN_GIAI)
            .trangThai(UPDATED_TRANG_THAI)
            .strSearch(UPDATED_STR_SEARCH);
        return danhMucLoaiDuongSu;
    }

    @BeforeEach
    public void initTest() {
        danhMucLoaiDuongSu = createEntity(em);
    }

    @AfterEach
    public void cleanup() {
        if (insertedDanhMucLoaiDuongSu != null) {
            danhMucLoaiDuongSuRepository.delete(insertedDanhMucLoaiDuongSu);
            insertedDanhMucLoaiDuongSu = null;
        }
    }

    @Test
    @Transactional
    void createDanhMucLoaiDuongSu() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the DanhMucLoaiDuongSu
        DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO = danhMucLoaiDuongSuMapper.toDto(danhMucLoaiDuongSu);
        var returnedDanhMucLoaiDuongSuDTO = om.readValue(
            restDanhMucLoaiDuongSuMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(danhMucLoaiDuongSuDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            DanhMucLoaiDuongSuDTO.class
        );

        // Validate the DanhMucLoaiDuongSu in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedDanhMucLoaiDuongSu = danhMucLoaiDuongSuMapper.toEntity(returnedDanhMucLoaiDuongSuDTO);
        assertDanhMucLoaiDuongSuUpdatableFieldsEquals(
            returnedDanhMucLoaiDuongSu,
            getPersistedDanhMucLoaiDuongSu(returnedDanhMucLoaiDuongSu)
        );

        insertedDanhMucLoaiDuongSu = returnedDanhMucLoaiDuongSu;
    }

    @Test
    @Transactional
    void createDanhMucLoaiDuongSuWithExistingId() throws Exception {
        // Create the DanhMucLoaiDuongSu with an existing ID
        danhMucLoaiDuongSu.setId(1L);
        DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO = danhMucLoaiDuongSuMapper.toDto(danhMucLoaiDuongSu);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restDanhMucLoaiDuongSuMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(danhMucLoaiDuongSuDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DanhMucLoaiDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllDanhMucLoaiDuongSus() throws Exception {
        // Initialize the database
        insertedDanhMucLoaiDuongSu = danhMucLoaiDuongSuRepository.saveAndFlush(danhMucLoaiDuongSu);

        // Get all the danhMucLoaiDuongSuList
        restDanhMucLoaiDuongSuMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(danhMucLoaiDuongSu.getId().intValue())))
            .andExpect(jsonPath("$.[*].idLoaiDs").value(hasItem(DEFAULT_ID_LOAI_DS.intValue())))
            .andExpect(jsonPath("$.[*].dienGiai").value(hasItem(DEFAULT_DIEN_GIAI)))
            .andExpect(jsonPath("$.[*].trangThai").value(hasItem(DEFAULT_TRANG_THAI.intValue())))
            .andExpect(jsonPath("$.[*].strSearch").value(hasItem(DEFAULT_STR_SEARCH)));
    }

    @Test
    @Transactional
    void getDanhMucLoaiDuongSu() throws Exception {
        // Initialize the database
        insertedDanhMucLoaiDuongSu = danhMucLoaiDuongSuRepository.saveAndFlush(danhMucLoaiDuongSu);

        // Get the danhMucLoaiDuongSu
        restDanhMucLoaiDuongSuMockMvc
            .perform(get(ENTITY_API_URL_ID, danhMucLoaiDuongSu.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(danhMucLoaiDuongSu.getId().intValue()))
            .andExpect(jsonPath("$.idLoaiDs").value(DEFAULT_ID_LOAI_DS.intValue()))
            .andExpect(jsonPath("$.dienGiai").value(DEFAULT_DIEN_GIAI))
            .andExpect(jsonPath("$.trangThai").value(DEFAULT_TRANG_THAI.intValue()))
            .andExpect(jsonPath("$.strSearch").value(DEFAULT_STR_SEARCH));
    }

    @Test
    @Transactional
    void getNonExistingDanhMucLoaiDuongSu() throws Exception {
        // Get the danhMucLoaiDuongSu
        restDanhMucLoaiDuongSuMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingDanhMucLoaiDuongSu() throws Exception {
        // Initialize the database
        insertedDanhMucLoaiDuongSu = danhMucLoaiDuongSuRepository.saveAndFlush(danhMucLoaiDuongSu);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the danhMucLoaiDuongSu
        DanhMucLoaiDuongSu updatedDanhMucLoaiDuongSu = danhMucLoaiDuongSuRepository.findById(danhMucLoaiDuongSu.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedDanhMucLoaiDuongSu are not directly saved in db
        em.detach(updatedDanhMucLoaiDuongSu);
        updatedDanhMucLoaiDuongSu
            .idLoaiDs(UPDATED_ID_LOAI_DS)
            .dienGiai(UPDATED_DIEN_GIAI)
            .trangThai(UPDATED_TRANG_THAI)
            .strSearch(UPDATED_STR_SEARCH);
        DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO = danhMucLoaiDuongSuMapper.toDto(updatedDanhMucLoaiDuongSu);

        restDanhMucLoaiDuongSuMockMvc
            .perform(
                put(ENTITY_API_URL_ID, danhMucLoaiDuongSuDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(danhMucLoaiDuongSuDTO))
            )
            .andExpect(status().isOk());

        // Validate the DanhMucLoaiDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedDanhMucLoaiDuongSuToMatchAllProperties(updatedDanhMucLoaiDuongSu);
    }

    @Test
    @Transactional
    void putNonExistingDanhMucLoaiDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        danhMucLoaiDuongSu.setId(longCount.incrementAndGet());

        // Create the DanhMucLoaiDuongSu
        DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO = danhMucLoaiDuongSuMapper.toDto(danhMucLoaiDuongSu);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDanhMucLoaiDuongSuMockMvc
            .perform(
                put(ENTITY_API_URL_ID, danhMucLoaiDuongSuDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(danhMucLoaiDuongSuDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DanhMucLoaiDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchDanhMucLoaiDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        danhMucLoaiDuongSu.setId(longCount.incrementAndGet());

        // Create the DanhMucLoaiDuongSu
        DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO = danhMucLoaiDuongSuMapper.toDto(danhMucLoaiDuongSu);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDanhMucLoaiDuongSuMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(danhMucLoaiDuongSuDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DanhMucLoaiDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamDanhMucLoaiDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        danhMucLoaiDuongSu.setId(longCount.incrementAndGet());

        // Create the DanhMucLoaiDuongSu
        DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO = danhMucLoaiDuongSuMapper.toDto(danhMucLoaiDuongSu);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDanhMucLoaiDuongSuMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(danhMucLoaiDuongSuDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the DanhMucLoaiDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateDanhMucLoaiDuongSuWithPatch() throws Exception {
        // Initialize the database
        insertedDanhMucLoaiDuongSu = danhMucLoaiDuongSuRepository.saveAndFlush(danhMucLoaiDuongSu);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the danhMucLoaiDuongSu using partial update
        DanhMucLoaiDuongSu partialUpdatedDanhMucLoaiDuongSu = new DanhMucLoaiDuongSu();
        partialUpdatedDanhMucLoaiDuongSu.setId(danhMucLoaiDuongSu.getId());

        partialUpdatedDanhMucLoaiDuongSu.idLoaiDs(UPDATED_ID_LOAI_DS);

        restDanhMucLoaiDuongSuMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDanhMucLoaiDuongSu.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedDanhMucLoaiDuongSu))
            )
            .andExpect(status().isOk());

        // Validate the DanhMucLoaiDuongSu in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertDanhMucLoaiDuongSuUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedDanhMucLoaiDuongSu, danhMucLoaiDuongSu),
            getPersistedDanhMucLoaiDuongSu(danhMucLoaiDuongSu)
        );
    }

    @Test
    @Transactional
    void fullUpdateDanhMucLoaiDuongSuWithPatch() throws Exception {
        // Initialize the database
        insertedDanhMucLoaiDuongSu = danhMucLoaiDuongSuRepository.saveAndFlush(danhMucLoaiDuongSu);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the danhMucLoaiDuongSu using partial update
        DanhMucLoaiDuongSu partialUpdatedDanhMucLoaiDuongSu = new DanhMucLoaiDuongSu();
        partialUpdatedDanhMucLoaiDuongSu.setId(danhMucLoaiDuongSu.getId());

        partialUpdatedDanhMucLoaiDuongSu
            .idLoaiDs(UPDATED_ID_LOAI_DS)
            .dienGiai(UPDATED_DIEN_GIAI)
            .trangThai(UPDATED_TRANG_THAI)
            .strSearch(UPDATED_STR_SEARCH);

        restDanhMucLoaiDuongSuMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDanhMucLoaiDuongSu.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedDanhMucLoaiDuongSu))
            )
            .andExpect(status().isOk());

        // Validate the DanhMucLoaiDuongSu in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertDanhMucLoaiDuongSuUpdatableFieldsEquals(
            partialUpdatedDanhMucLoaiDuongSu,
            getPersistedDanhMucLoaiDuongSu(partialUpdatedDanhMucLoaiDuongSu)
        );
    }

    @Test
    @Transactional
    void patchNonExistingDanhMucLoaiDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        danhMucLoaiDuongSu.setId(longCount.incrementAndGet());

        // Create the DanhMucLoaiDuongSu
        DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO = danhMucLoaiDuongSuMapper.toDto(danhMucLoaiDuongSu);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDanhMucLoaiDuongSuMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, danhMucLoaiDuongSuDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(danhMucLoaiDuongSuDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DanhMucLoaiDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchDanhMucLoaiDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        danhMucLoaiDuongSu.setId(longCount.incrementAndGet());

        // Create the DanhMucLoaiDuongSu
        DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO = danhMucLoaiDuongSuMapper.toDto(danhMucLoaiDuongSu);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDanhMucLoaiDuongSuMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(danhMucLoaiDuongSuDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DanhMucLoaiDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamDanhMucLoaiDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        danhMucLoaiDuongSu.setId(longCount.incrementAndGet());

        // Create the DanhMucLoaiDuongSu
        DanhMucLoaiDuongSuDTO danhMucLoaiDuongSuDTO = danhMucLoaiDuongSuMapper.toDto(danhMucLoaiDuongSu);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDanhMucLoaiDuongSuMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(danhMucLoaiDuongSuDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the DanhMucLoaiDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteDanhMucLoaiDuongSu() throws Exception {
        // Initialize the database
        insertedDanhMucLoaiDuongSu = danhMucLoaiDuongSuRepository.saveAndFlush(danhMucLoaiDuongSu);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the danhMucLoaiDuongSu
        restDanhMucLoaiDuongSuMockMvc
            .perform(delete(ENTITY_API_URL_ID, danhMucLoaiDuongSu.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return danhMucLoaiDuongSuRepository.count();
    }

    protected void assertIncrementedRepositoryCount(long countBefore) {
        assertThat(countBefore + 1).isEqualTo(getRepositoryCount());
    }

    protected void assertDecrementedRepositoryCount(long countBefore) {
        assertThat(countBefore - 1).isEqualTo(getRepositoryCount());
    }

    protected void assertSameRepositoryCount(long countBefore) {
        assertThat(countBefore).isEqualTo(getRepositoryCount());
    }

    protected DanhMucLoaiDuongSu getPersistedDanhMucLoaiDuongSu(DanhMucLoaiDuongSu danhMucLoaiDuongSu) {
        return danhMucLoaiDuongSuRepository.findById(danhMucLoaiDuongSu.getId()).orElseThrow();
    }

    protected void assertPersistedDanhMucLoaiDuongSuToMatchAllProperties(DanhMucLoaiDuongSu expectedDanhMucLoaiDuongSu) {
        assertDanhMucLoaiDuongSuAllPropertiesEquals(expectedDanhMucLoaiDuongSu, getPersistedDanhMucLoaiDuongSu(expectedDanhMucLoaiDuongSu));
    }

    protected void assertPersistedDanhMucLoaiDuongSuToMatchUpdatableProperties(DanhMucLoaiDuongSu expectedDanhMucLoaiDuongSu) {
        assertDanhMucLoaiDuongSuAllUpdatablePropertiesEquals(
            expectedDanhMucLoaiDuongSu,
            getPersistedDanhMucLoaiDuongSu(expectedDanhMucLoaiDuongSu)
        );
    }
}
