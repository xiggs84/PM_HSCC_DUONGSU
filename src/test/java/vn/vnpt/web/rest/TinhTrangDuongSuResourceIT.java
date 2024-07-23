package vn.vnpt.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static vn.vnpt.domain.TinhTrangDuongSuAsserts.*;
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
import vn.vnpt.domain.TinhTrangDuongSu;
import vn.vnpt.repository.TinhTrangDuongSuRepository;
import vn.vnpt.service.dto.TinhTrangDuongSuDTO;
import vn.vnpt.service.mapper.TinhTrangDuongSuMapper;

/**
 * Integration tests for the {@link TinhTrangDuongSuResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TinhTrangDuongSuResourceIT {

    private static final Long DEFAULT_ID_TINH_TRANG = 1L;
    private static final Long UPDATED_ID_TINH_TRANG = 2L;

    private static final String DEFAULT_DIEN_GIAI = "AAAAAAAAAA";
    private static final String UPDATED_DIEN_GIAI = "BBBBBBBBBB";

    private static final Long DEFAULT_ID_LOAI_DS = 1L;
    private static final Long UPDATED_ID_LOAI_DS = 2L;

    private static final String ENTITY_API_URL = "/api/tinh-trang-duong-sus";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TinhTrangDuongSuRepository tinhTrangDuongSuRepository;

    @Autowired
    private TinhTrangDuongSuMapper tinhTrangDuongSuMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTinhTrangDuongSuMockMvc;

    private TinhTrangDuongSu tinhTrangDuongSu;

    private TinhTrangDuongSu insertedTinhTrangDuongSu;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TinhTrangDuongSu createEntity(EntityManager em) {
        TinhTrangDuongSu tinhTrangDuongSu = new TinhTrangDuongSu()
            .idTinhTrang(DEFAULT_ID_TINH_TRANG)
            .dienGiai(DEFAULT_DIEN_GIAI)
            .idLoaiDs(DEFAULT_ID_LOAI_DS);
        return tinhTrangDuongSu;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TinhTrangDuongSu createUpdatedEntity(EntityManager em) {
        TinhTrangDuongSu tinhTrangDuongSu = new TinhTrangDuongSu()
            .idTinhTrang(UPDATED_ID_TINH_TRANG)
            .dienGiai(UPDATED_DIEN_GIAI)
            .idLoaiDs(UPDATED_ID_LOAI_DS);
        return tinhTrangDuongSu;
    }

    @BeforeEach
    public void initTest() {
        tinhTrangDuongSu = createEntity(em);
    }

    @AfterEach
    public void cleanup() {
        if (insertedTinhTrangDuongSu != null) {
            tinhTrangDuongSuRepository.delete(insertedTinhTrangDuongSu);
            insertedTinhTrangDuongSu = null;
        }
    }

    @Test
    @Transactional
    void createTinhTrangDuongSu() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the TinhTrangDuongSu
        TinhTrangDuongSuDTO tinhTrangDuongSuDTO = tinhTrangDuongSuMapper.toDto(tinhTrangDuongSu);
        var returnedTinhTrangDuongSuDTO = om.readValue(
            restTinhTrangDuongSuMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tinhTrangDuongSuDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            TinhTrangDuongSuDTO.class
        );

        // Validate the TinhTrangDuongSu in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedTinhTrangDuongSu = tinhTrangDuongSuMapper.toEntity(returnedTinhTrangDuongSuDTO);
        assertTinhTrangDuongSuUpdatableFieldsEquals(returnedTinhTrangDuongSu, getPersistedTinhTrangDuongSu(returnedTinhTrangDuongSu));

        insertedTinhTrangDuongSu = returnedTinhTrangDuongSu;
    }

    @Test
    @Transactional
    void createTinhTrangDuongSuWithExistingId() throws Exception {
        // Create the TinhTrangDuongSu with an existing ID
        tinhTrangDuongSu.setId(1L);
        TinhTrangDuongSuDTO tinhTrangDuongSuDTO = tinhTrangDuongSuMapper.toDto(tinhTrangDuongSu);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restTinhTrangDuongSuMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tinhTrangDuongSuDTO)))
            .andExpect(status().isBadRequest());

        // Validate the TinhTrangDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllTinhTrangDuongSus() throws Exception {
        // Initialize the database
        insertedTinhTrangDuongSu = tinhTrangDuongSuRepository.saveAndFlush(tinhTrangDuongSu);

        // Get all the tinhTrangDuongSuList
        restTinhTrangDuongSuMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(tinhTrangDuongSu.getId().intValue())))
            .andExpect(jsonPath("$.[*].idTinhTrang").value(hasItem(DEFAULT_ID_TINH_TRANG.intValue())))
            .andExpect(jsonPath("$.[*].dienGiai").value(hasItem(DEFAULT_DIEN_GIAI)))
            .andExpect(jsonPath("$.[*].idLoaiDs").value(hasItem(DEFAULT_ID_LOAI_DS.intValue())));
    }

    @Test
    @Transactional
    void getTinhTrangDuongSu() throws Exception {
        // Initialize the database
        insertedTinhTrangDuongSu = tinhTrangDuongSuRepository.saveAndFlush(tinhTrangDuongSu);

        // Get the tinhTrangDuongSu
        restTinhTrangDuongSuMockMvc
            .perform(get(ENTITY_API_URL_ID, tinhTrangDuongSu.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(tinhTrangDuongSu.getId().intValue()))
            .andExpect(jsonPath("$.idTinhTrang").value(DEFAULT_ID_TINH_TRANG.intValue()))
            .andExpect(jsonPath("$.dienGiai").value(DEFAULT_DIEN_GIAI))
            .andExpect(jsonPath("$.idLoaiDs").value(DEFAULT_ID_LOAI_DS.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingTinhTrangDuongSu() throws Exception {
        // Get the tinhTrangDuongSu
        restTinhTrangDuongSuMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingTinhTrangDuongSu() throws Exception {
        // Initialize the database
        insertedTinhTrangDuongSu = tinhTrangDuongSuRepository.saveAndFlush(tinhTrangDuongSu);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the tinhTrangDuongSu
        TinhTrangDuongSu updatedTinhTrangDuongSu = tinhTrangDuongSuRepository.findById(tinhTrangDuongSu.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedTinhTrangDuongSu are not directly saved in db
        em.detach(updatedTinhTrangDuongSu);
        updatedTinhTrangDuongSu.idTinhTrang(UPDATED_ID_TINH_TRANG).dienGiai(UPDATED_DIEN_GIAI).idLoaiDs(UPDATED_ID_LOAI_DS);
        TinhTrangDuongSuDTO tinhTrangDuongSuDTO = tinhTrangDuongSuMapper.toDto(updatedTinhTrangDuongSu);

        restTinhTrangDuongSuMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tinhTrangDuongSuDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(tinhTrangDuongSuDTO))
            )
            .andExpect(status().isOk());

        // Validate the TinhTrangDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedTinhTrangDuongSuToMatchAllProperties(updatedTinhTrangDuongSu);
    }

    @Test
    @Transactional
    void putNonExistingTinhTrangDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        tinhTrangDuongSu.setId(longCount.incrementAndGet());

        // Create the TinhTrangDuongSu
        TinhTrangDuongSuDTO tinhTrangDuongSuDTO = tinhTrangDuongSuMapper.toDto(tinhTrangDuongSu);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTinhTrangDuongSuMockMvc
            .perform(
                put(ENTITY_API_URL_ID, tinhTrangDuongSuDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(tinhTrangDuongSuDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TinhTrangDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchTinhTrangDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        tinhTrangDuongSu.setId(longCount.incrementAndGet());

        // Create the TinhTrangDuongSu
        TinhTrangDuongSuDTO tinhTrangDuongSuDTO = tinhTrangDuongSuMapper.toDto(tinhTrangDuongSu);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTinhTrangDuongSuMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(tinhTrangDuongSuDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TinhTrangDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamTinhTrangDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        tinhTrangDuongSu.setId(longCount.incrementAndGet());

        // Create the TinhTrangDuongSu
        TinhTrangDuongSuDTO tinhTrangDuongSuDTO = tinhTrangDuongSuMapper.toDto(tinhTrangDuongSu);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTinhTrangDuongSuMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(tinhTrangDuongSuDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the TinhTrangDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateTinhTrangDuongSuWithPatch() throws Exception {
        // Initialize the database
        insertedTinhTrangDuongSu = tinhTrangDuongSuRepository.saveAndFlush(tinhTrangDuongSu);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the tinhTrangDuongSu using partial update
        TinhTrangDuongSu partialUpdatedTinhTrangDuongSu = new TinhTrangDuongSu();
        partialUpdatedTinhTrangDuongSu.setId(tinhTrangDuongSu.getId());

        partialUpdatedTinhTrangDuongSu.dienGiai(UPDATED_DIEN_GIAI);

        restTinhTrangDuongSuMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTinhTrangDuongSu.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedTinhTrangDuongSu))
            )
            .andExpect(status().isOk());

        // Validate the TinhTrangDuongSu in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertTinhTrangDuongSuUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedTinhTrangDuongSu, tinhTrangDuongSu),
            getPersistedTinhTrangDuongSu(tinhTrangDuongSu)
        );
    }

    @Test
    @Transactional
    void fullUpdateTinhTrangDuongSuWithPatch() throws Exception {
        // Initialize the database
        insertedTinhTrangDuongSu = tinhTrangDuongSuRepository.saveAndFlush(tinhTrangDuongSu);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the tinhTrangDuongSu using partial update
        TinhTrangDuongSu partialUpdatedTinhTrangDuongSu = new TinhTrangDuongSu();
        partialUpdatedTinhTrangDuongSu.setId(tinhTrangDuongSu.getId());

        partialUpdatedTinhTrangDuongSu.idTinhTrang(UPDATED_ID_TINH_TRANG).dienGiai(UPDATED_DIEN_GIAI).idLoaiDs(UPDATED_ID_LOAI_DS);

        restTinhTrangDuongSuMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedTinhTrangDuongSu.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedTinhTrangDuongSu))
            )
            .andExpect(status().isOk());

        // Validate the TinhTrangDuongSu in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertTinhTrangDuongSuUpdatableFieldsEquals(
            partialUpdatedTinhTrangDuongSu,
            getPersistedTinhTrangDuongSu(partialUpdatedTinhTrangDuongSu)
        );
    }

    @Test
    @Transactional
    void patchNonExistingTinhTrangDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        tinhTrangDuongSu.setId(longCount.incrementAndGet());

        // Create the TinhTrangDuongSu
        TinhTrangDuongSuDTO tinhTrangDuongSuDTO = tinhTrangDuongSuMapper.toDto(tinhTrangDuongSu);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTinhTrangDuongSuMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, tinhTrangDuongSuDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(tinhTrangDuongSuDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TinhTrangDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchTinhTrangDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        tinhTrangDuongSu.setId(longCount.incrementAndGet());

        // Create the TinhTrangDuongSu
        TinhTrangDuongSuDTO tinhTrangDuongSuDTO = tinhTrangDuongSuMapper.toDto(tinhTrangDuongSu);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTinhTrangDuongSuMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(tinhTrangDuongSuDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the TinhTrangDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamTinhTrangDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        tinhTrangDuongSu.setId(longCount.incrementAndGet());

        // Create the TinhTrangDuongSu
        TinhTrangDuongSuDTO tinhTrangDuongSuDTO = tinhTrangDuongSuMapper.toDto(tinhTrangDuongSu);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restTinhTrangDuongSuMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(tinhTrangDuongSuDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the TinhTrangDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteTinhTrangDuongSu() throws Exception {
        // Initialize the database
        insertedTinhTrangDuongSu = tinhTrangDuongSuRepository.saveAndFlush(tinhTrangDuongSu);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the tinhTrangDuongSu
        restTinhTrangDuongSuMockMvc
            .perform(delete(ENTITY_API_URL_ID, tinhTrangDuongSu.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return tinhTrangDuongSuRepository.count();
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

    protected TinhTrangDuongSu getPersistedTinhTrangDuongSu(TinhTrangDuongSu tinhTrangDuongSu) {
        return tinhTrangDuongSuRepository.findById(tinhTrangDuongSu.getId()).orElseThrow();
    }

    protected void assertPersistedTinhTrangDuongSuToMatchAllProperties(TinhTrangDuongSu expectedTinhTrangDuongSu) {
        assertTinhTrangDuongSuAllPropertiesEquals(expectedTinhTrangDuongSu, getPersistedTinhTrangDuongSu(expectedTinhTrangDuongSu));
    }

    protected void assertPersistedTinhTrangDuongSuToMatchUpdatableProperties(TinhTrangDuongSu expectedTinhTrangDuongSu) {
        assertTinhTrangDuongSuAllUpdatablePropertiesEquals(
            expectedTinhTrangDuongSu,
            getPersistedTinhTrangDuongSu(expectedTinhTrangDuongSu)
        );
    }
}
