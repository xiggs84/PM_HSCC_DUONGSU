package vn.vnpt.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static vn.vnpt.domain.DanhMucTinhTrangHonNhanAsserts.*;
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
import vn.vnpt.domain.DanhMucTinhTrangHonNhan;
import vn.vnpt.repository.DanhMucTinhTrangHonNhanRepository;
import vn.vnpt.service.dto.DanhMucTinhTrangHonNhanDTO;
import vn.vnpt.service.mapper.DanhMucTinhTrangHonNhanMapper;

/**
 * Integration tests for the {@link DanhMucTinhTrangHonNhanResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class DanhMucTinhTrangHonNhanResourceIT {

    private static final Long DEFAULT_ID_TINH_TRANG = 1L;
    private static final Long UPDATED_ID_TINH_TRANG = 2L;

    private static final String DEFAULT_DIEN_GIAI = "AAAAAAAAAA";
    private static final String UPDATED_DIEN_GIAI = "BBBBBBBBBB";

    private static final Long DEFAULT_TRANG_THAI = 1L;
    private static final Long UPDATED_TRANG_THAI = 2L;

    private static final String ENTITY_API_URL = "/api/danh-muc-tinh-trang-hon-nhans";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private DanhMucTinhTrangHonNhanRepository danhMucTinhTrangHonNhanRepository;

    @Autowired
    private DanhMucTinhTrangHonNhanMapper danhMucTinhTrangHonNhanMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDanhMucTinhTrangHonNhanMockMvc;

    private DanhMucTinhTrangHonNhan danhMucTinhTrangHonNhan;

    private DanhMucTinhTrangHonNhan insertedDanhMucTinhTrangHonNhan;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DanhMucTinhTrangHonNhan createEntity(EntityManager em) {
        DanhMucTinhTrangHonNhan danhMucTinhTrangHonNhan = new DanhMucTinhTrangHonNhan()
            .idTinhTrang(DEFAULT_ID_TINH_TRANG)
            .dienGiai(DEFAULT_DIEN_GIAI)
            .trangThai(DEFAULT_TRANG_THAI);
        return danhMucTinhTrangHonNhan;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DanhMucTinhTrangHonNhan createUpdatedEntity(EntityManager em) {
        DanhMucTinhTrangHonNhan danhMucTinhTrangHonNhan = new DanhMucTinhTrangHonNhan()
            .idTinhTrang(UPDATED_ID_TINH_TRANG)
            .dienGiai(UPDATED_DIEN_GIAI)
            .trangThai(UPDATED_TRANG_THAI);
        return danhMucTinhTrangHonNhan;
    }

    @BeforeEach
    public void initTest() {
        danhMucTinhTrangHonNhan = createEntity(em);
    }

    @AfterEach
    public void cleanup() {
        if (insertedDanhMucTinhTrangHonNhan != null) {
            danhMucTinhTrangHonNhanRepository.delete(insertedDanhMucTinhTrangHonNhan);
            insertedDanhMucTinhTrangHonNhan = null;
        }
    }

    @Test
    @Transactional
    void createDanhMucTinhTrangHonNhan() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the DanhMucTinhTrangHonNhan
        DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO = danhMucTinhTrangHonNhanMapper.toDto(danhMucTinhTrangHonNhan);
        var returnedDanhMucTinhTrangHonNhanDTO = om.readValue(
            restDanhMucTinhTrangHonNhanMockMvc
                .perform(
                    post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(danhMucTinhTrangHonNhanDTO))
                )
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            DanhMucTinhTrangHonNhanDTO.class
        );

        // Validate the DanhMucTinhTrangHonNhan in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedDanhMucTinhTrangHonNhan = danhMucTinhTrangHonNhanMapper.toEntity(returnedDanhMucTinhTrangHonNhanDTO);
        assertDanhMucTinhTrangHonNhanUpdatableFieldsEquals(
            returnedDanhMucTinhTrangHonNhan,
            getPersistedDanhMucTinhTrangHonNhan(returnedDanhMucTinhTrangHonNhan)
        );

        insertedDanhMucTinhTrangHonNhan = returnedDanhMucTinhTrangHonNhan;
    }

    @Test
    @Transactional
    void createDanhMucTinhTrangHonNhanWithExistingId() throws Exception {
        // Create the DanhMucTinhTrangHonNhan with an existing ID
        danhMucTinhTrangHonNhan.setId(1L);
        DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO = danhMucTinhTrangHonNhanMapper.toDto(danhMucTinhTrangHonNhan);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restDanhMucTinhTrangHonNhanMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(danhMucTinhTrangHonNhanDTO)))
            .andExpect(status().isBadRequest());

        // Validate the DanhMucTinhTrangHonNhan in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllDanhMucTinhTrangHonNhans() throws Exception {
        // Initialize the database
        insertedDanhMucTinhTrangHonNhan = danhMucTinhTrangHonNhanRepository.saveAndFlush(danhMucTinhTrangHonNhan);

        // Get all the danhMucTinhTrangHonNhanList
        restDanhMucTinhTrangHonNhanMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(danhMucTinhTrangHonNhan.getId().intValue())))
            .andExpect(jsonPath("$.[*].idTinhTrang").value(hasItem(DEFAULT_ID_TINH_TRANG.intValue())))
            .andExpect(jsonPath("$.[*].dienGiai").value(hasItem(DEFAULT_DIEN_GIAI)))
            .andExpect(jsonPath("$.[*].trangThai").value(hasItem(DEFAULT_TRANG_THAI.intValue())));
    }

    @Test
    @Transactional
    void getDanhMucTinhTrangHonNhan() throws Exception {
        // Initialize the database
        insertedDanhMucTinhTrangHonNhan = danhMucTinhTrangHonNhanRepository.saveAndFlush(danhMucTinhTrangHonNhan);

        // Get the danhMucTinhTrangHonNhan
        restDanhMucTinhTrangHonNhanMockMvc
            .perform(get(ENTITY_API_URL_ID, danhMucTinhTrangHonNhan.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(danhMucTinhTrangHonNhan.getId().intValue()))
            .andExpect(jsonPath("$.idTinhTrang").value(DEFAULT_ID_TINH_TRANG.intValue()))
            .andExpect(jsonPath("$.dienGiai").value(DEFAULT_DIEN_GIAI))
            .andExpect(jsonPath("$.trangThai").value(DEFAULT_TRANG_THAI.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingDanhMucTinhTrangHonNhan() throws Exception {
        // Get the danhMucTinhTrangHonNhan
        restDanhMucTinhTrangHonNhanMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingDanhMucTinhTrangHonNhan() throws Exception {
        // Initialize the database
        insertedDanhMucTinhTrangHonNhan = danhMucTinhTrangHonNhanRepository.saveAndFlush(danhMucTinhTrangHonNhan);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the danhMucTinhTrangHonNhan
        DanhMucTinhTrangHonNhan updatedDanhMucTinhTrangHonNhan = danhMucTinhTrangHonNhanRepository
            .findById(danhMucTinhTrangHonNhan.getId())
            .orElseThrow();
        // Disconnect from session so that the updates on updatedDanhMucTinhTrangHonNhan are not directly saved in db
        em.detach(updatedDanhMucTinhTrangHonNhan);
        updatedDanhMucTinhTrangHonNhan.idTinhTrang(UPDATED_ID_TINH_TRANG).dienGiai(UPDATED_DIEN_GIAI).trangThai(UPDATED_TRANG_THAI);
        DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO = danhMucTinhTrangHonNhanMapper.toDto(updatedDanhMucTinhTrangHonNhan);

        restDanhMucTinhTrangHonNhanMockMvc
            .perform(
                put(ENTITY_API_URL_ID, danhMucTinhTrangHonNhanDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(danhMucTinhTrangHonNhanDTO))
            )
            .andExpect(status().isOk());

        // Validate the DanhMucTinhTrangHonNhan in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedDanhMucTinhTrangHonNhanToMatchAllProperties(updatedDanhMucTinhTrangHonNhan);
    }

    @Test
    @Transactional
    void putNonExistingDanhMucTinhTrangHonNhan() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        danhMucTinhTrangHonNhan.setId(longCount.incrementAndGet());

        // Create the DanhMucTinhTrangHonNhan
        DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO = danhMucTinhTrangHonNhanMapper.toDto(danhMucTinhTrangHonNhan);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDanhMucTinhTrangHonNhanMockMvc
            .perform(
                put(ENTITY_API_URL_ID, danhMucTinhTrangHonNhanDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(danhMucTinhTrangHonNhanDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DanhMucTinhTrangHonNhan in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchDanhMucTinhTrangHonNhan() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        danhMucTinhTrangHonNhan.setId(longCount.incrementAndGet());

        // Create the DanhMucTinhTrangHonNhan
        DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO = danhMucTinhTrangHonNhanMapper.toDto(danhMucTinhTrangHonNhan);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDanhMucTinhTrangHonNhanMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(danhMucTinhTrangHonNhanDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DanhMucTinhTrangHonNhan in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamDanhMucTinhTrangHonNhan() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        danhMucTinhTrangHonNhan.setId(longCount.incrementAndGet());

        // Create the DanhMucTinhTrangHonNhan
        DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO = danhMucTinhTrangHonNhanMapper.toDto(danhMucTinhTrangHonNhan);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDanhMucTinhTrangHonNhanMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(danhMucTinhTrangHonNhanDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the DanhMucTinhTrangHonNhan in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateDanhMucTinhTrangHonNhanWithPatch() throws Exception {
        // Initialize the database
        insertedDanhMucTinhTrangHonNhan = danhMucTinhTrangHonNhanRepository.saveAndFlush(danhMucTinhTrangHonNhan);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the danhMucTinhTrangHonNhan using partial update
        DanhMucTinhTrangHonNhan partialUpdatedDanhMucTinhTrangHonNhan = new DanhMucTinhTrangHonNhan();
        partialUpdatedDanhMucTinhTrangHonNhan.setId(danhMucTinhTrangHonNhan.getId());

        restDanhMucTinhTrangHonNhanMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDanhMucTinhTrangHonNhan.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedDanhMucTinhTrangHonNhan))
            )
            .andExpect(status().isOk());

        // Validate the DanhMucTinhTrangHonNhan in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertDanhMucTinhTrangHonNhanUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedDanhMucTinhTrangHonNhan, danhMucTinhTrangHonNhan),
            getPersistedDanhMucTinhTrangHonNhan(danhMucTinhTrangHonNhan)
        );
    }

    @Test
    @Transactional
    void fullUpdateDanhMucTinhTrangHonNhanWithPatch() throws Exception {
        // Initialize the database
        insertedDanhMucTinhTrangHonNhan = danhMucTinhTrangHonNhanRepository.saveAndFlush(danhMucTinhTrangHonNhan);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the danhMucTinhTrangHonNhan using partial update
        DanhMucTinhTrangHonNhan partialUpdatedDanhMucTinhTrangHonNhan = new DanhMucTinhTrangHonNhan();
        partialUpdatedDanhMucTinhTrangHonNhan.setId(danhMucTinhTrangHonNhan.getId());

        partialUpdatedDanhMucTinhTrangHonNhan.idTinhTrang(UPDATED_ID_TINH_TRANG).dienGiai(UPDATED_DIEN_GIAI).trangThai(UPDATED_TRANG_THAI);

        restDanhMucTinhTrangHonNhanMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDanhMucTinhTrangHonNhan.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedDanhMucTinhTrangHonNhan))
            )
            .andExpect(status().isOk());

        // Validate the DanhMucTinhTrangHonNhan in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertDanhMucTinhTrangHonNhanUpdatableFieldsEquals(
            partialUpdatedDanhMucTinhTrangHonNhan,
            getPersistedDanhMucTinhTrangHonNhan(partialUpdatedDanhMucTinhTrangHonNhan)
        );
    }

    @Test
    @Transactional
    void patchNonExistingDanhMucTinhTrangHonNhan() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        danhMucTinhTrangHonNhan.setId(longCount.incrementAndGet());

        // Create the DanhMucTinhTrangHonNhan
        DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO = danhMucTinhTrangHonNhanMapper.toDto(danhMucTinhTrangHonNhan);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDanhMucTinhTrangHonNhanMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, danhMucTinhTrangHonNhanDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(danhMucTinhTrangHonNhanDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DanhMucTinhTrangHonNhan in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchDanhMucTinhTrangHonNhan() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        danhMucTinhTrangHonNhan.setId(longCount.incrementAndGet());

        // Create the DanhMucTinhTrangHonNhan
        DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO = danhMucTinhTrangHonNhanMapper.toDto(danhMucTinhTrangHonNhan);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDanhMucTinhTrangHonNhanMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(danhMucTinhTrangHonNhanDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DanhMucTinhTrangHonNhan in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamDanhMucTinhTrangHonNhan() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        danhMucTinhTrangHonNhan.setId(longCount.incrementAndGet());

        // Create the DanhMucTinhTrangHonNhan
        DanhMucTinhTrangHonNhanDTO danhMucTinhTrangHonNhanDTO = danhMucTinhTrangHonNhanMapper.toDto(danhMucTinhTrangHonNhan);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDanhMucTinhTrangHonNhanMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(danhMucTinhTrangHonNhanDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the DanhMucTinhTrangHonNhan in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteDanhMucTinhTrangHonNhan() throws Exception {
        // Initialize the database
        insertedDanhMucTinhTrangHonNhan = danhMucTinhTrangHonNhanRepository.saveAndFlush(danhMucTinhTrangHonNhan);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the danhMucTinhTrangHonNhan
        restDanhMucTinhTrangHonNhanMockMvc
            .perform(delete(ENTITY_API_URL_ID, danhMucTinhTrangHonNhan.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return danhMucTinhTrangHonNhanRepository.count();
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

    protected DanhMucTinhTrangHonNhan getPersistedDanhMucTinhTrangHonNhan(DanhMucTinhTrangHonNhan danhMucTinhTrangHonNhan) {
        return danhMucTinhTrangHonNhanRepository.findById(danhMucTinhTrangHonNhan.getId()).orElseThrow();
    }

    protected void assertPersistedDanhMucTinhTrangHonNhanToMatchAllProperties(DanhMucTinhTrangHonNhan expectedDanhMucTinhTrangHonNhan) {
        assertDanhMucTinhTrangHonNhanAllPropertiesEquals(
            expectedDanhMucTinhTrangHonNhan,
            getPersistedDanhMucTinhTrangHonNhan(expectedDanhMucTinhTrangHonNhan)
        );
    }

    protected void assertPersistedDanhMucTinhTrangHonNhanToMatchUpdatableProperties(
        DanhMucTinhTrangHonNhan expectedDanhMucTinhTrangHonNhan
    ) {
        assertDanhMucTinhTrangHonNhanAllUpdatablePropertiesEquals(
            expectedDanhMucTinhTrangHonNhan,
            getPersistedDanhMucTinhTrangHonNhan(expectedDanhMucTinhTrangHonNhan)
        );
    }
}
