package vn.vnpt.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static vn.vnpt.domain.QuanHeDuongSuAsserts.*;
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
import vn.vnpt.domain.QuanHeDuongSu;
import vn.vnpt.repository.QuanHeDuongSuRepository;
import vn.vnpt.service.dto.QuanHeDuongSuDTO;
import vn.vnpt.service.mapper.QuanHeDuongSuMapper;

/**
 * Integration tests for the {@link QuanHeDuongSuResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class QuanHeDuongSuResourceIT {

    private static final Long DEFAULT_ID_DUONG_SU = 1L;
    private static final Long UPDATED_ID_DUONG_SU = 2L;

    private static final Long DEFAULT_ID_DUONG_SU_QH = 1L;
    private static final Long UPDATED_ID_DUONG_SU_QH = 2L;

    private static final Long DEFAULT_ID_QUAN_HE = 1L;
    private static final Long UPDATED_ID_QUAN_HE = 2L;

    private static final String DEFAULT_THONG_TIN_QUAN_HE = "AAAAAAAAAA";
    private static final String UPDATED_THONG_TIN_QUAN_HE = "BBBBBBBBBB";

    private static final Long DEFAULT_TRANG_THAI = 1L;
    private static final Long UPDATED_TRANG_THAI = 2L;

    private static final String ENTITY_API_URL = "/api/quan-he-duong-sus";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private ObjectMapper om;

    @Autowired
    private QuanHeDuongSuRepository quanHeDuongSuRepository;

    @Autowired
    private QuanHeDuongSuMapper quanHeDuongSuMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restQuanHeDuongSuMockMvc;

    private QuanHeDuongSu quanHeDuongSu;

    private QuanHeDuongSu insertedQuanHeDuongSu;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static QuanHeDuongSu createEntity(EntityManager em) {
        QuanHeDuongSu quanHeDuongSu = new QuanHeDuongSu()
            .idDuongSu(DEFAULT_ID_DUONG_SU)
            .idDuongSuQh(DEFAULT_ID_DUONG_SU_QH)
            .idQuanHe(DEFAULT_ID_QUAN_HE)
            .thongTinQuanHe(DEFAULT_THONG_TIN_QUAN_HE)
            .trangThai(DEFAULT_TRANG_THAI);
        return quanHeDuongSu;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static QuanHeDuongSu createUpdatedEntity(EntityManager em) {
        QuanHeDuongSu quanHeDuongSu = new QuanHeDuongSu()
            .idDuongSu(UPDATED_ID_DUONG_SU)
            .idDuongSuQh(UPDATED_ID_DUONG_SU_QH)
            .idQuanHe(UPDATED_ID_QUAN_HE)
            .thongTinQuanHe(UPDATED_THONG_TIN_QUAN_HE)
            .trangThai(UPDATED_TRANG_THAI);
        return quanHeDuongSu;
    }

    @BeforeEach
    public void initTest() {
        quanHeDuongSu = createEntity(em);
    }

    @AfterEach
    public void cleanup() {
        if (insertedQuanHeDuongSu != null) {
            quanHeDuongSuRepository.delete(insertedQuanHeDuongSu);
            insertedQuanHeDuongSu = null;
        }
    }

    @Test
    @Transactional
    void createQuanHeDuongSu() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the QuanHeDuongSu
        QuanHeDuongSuDTO quanHeDuongSuDTO = quanHeDuongSuMapper.toDto(quanHeDuongSu);
        var returnedQuanHeDuongSuDTO = om.readValue(
            restQuanHeDuongSuMockMvc
                .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(quanHeDuongSuDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(),
            QuanHeDuongSuDTO.class
        );

        // Validate the QuanHeDuongSu in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedQuanHeDuongSu = quanHeDuongSuMapper.toEntity(returnedQuanHeDuongSuDTO);
        assertQuanHeDuongSuUpdatableFieldsEquals(returnedQuanHeDuongSu, getPersistedQuanHeDuongSu(returnedQuanHeDuongSu));

        insertedQuanHeDuongSu = returnedQuanHeDuongSu;
    }

    @Test
    @Transactional
    void createQuanHeDuongSuWithExistingId() throws Exception {
        // Create the QuanHeDuongSu with an existing ID
        quanHeDuongSu.setId(1L);
        QuanHeDuongSuDTO quanHeDuongSuDTO = quanHeDuongSuMapper.toDto(quanHeDuongSu);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        restQuanHeDuongSuMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(quanHeDuongSuDTO)))
            .andExpect(status().isBadRequest());

        // Validate the QuanHeDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllQuanHeDuongSus() throws Exception {
        // Initialize the database
        insertedQuanHeDuongSu = quanHeDuongSuRepository.saveAndFlush(quanHeDuongSu);

        // Get all the quanHeDuongSuList
        restQuanHeDuongSuMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(quanHeDuongSu.getId().intValue())))
            .andExpect(jsonPath("$.[*].idDuongSu").value(hasItem(DEFAULT_ID_DUONG_SU.intValue())))
            .andExpect(jsonPath("$.[*].idDuongSuQh").value(hasItem(DEFAULT_ID_DUONG_SU_QH.intValue())))
            .andExpect(jsonPath("$.[*].idQuanHe").value(hasItem(DEFAULT_ID_QUAN_HE.intValue())))
            .andExpect(jsonPath("$.[*].thongTinQuanHe").value(hasItem(DEFAULT_THONG_TIN_QUAN_HE)))
            .andExpect(jsonPath("$.[*].trangThai").value(hasItem(DEFAULT_TRANG_THAI.intValue())));
    }

    @Test
    @Transactional
    void getQuanHeDuongSu() throws Exception {
        // Initialize the database
        insertedQuanHeDuongSu = quanHeDuongSuRepository.saveAndFlush(quanHeDuongSu);

        // Get the quanHeDuongSu
        restQuanHeDuongSuMockMvc
            .perform(get(ENTITY_API_URL_ID, quanHeDuongSu.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(quanHeDuongSu.getId().intValue()))
            .andExpect(jsonPath("$.idDuongSu").value(DEFAULT_ID_DUONG_SU.intValue()))
            .andExpect(jsonPath("$.idDuongSuQh").value(DEFAULT_ID_DUONG_SU_QH.intValue()))
            .andExpect(jsonPath("$.idQuanHe").value(DEFAULT_ID_QUAN_HE.intValue()))
            .andExpect(jsonPath("$.thongTinQuanHe").value(DEFAULT_THONG_TIN_QUAN_HE))
            .andExpect(jsonPath("$.trangThai").value(DEFAULT_TRANG_THAI.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingQuanHeDuongSu() throws Exception {
        // Get the quanHeDuongSu
        restQuanHeDuongSuMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putExistingQuanHeDuongSu() throws Exception {
        // Initialize the database
        insertedQuanHeDuongSu = quanHeDuongSuRepository.saveAndFlush(quanHeDuongSu);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the quanHeDuongSu
        QuanHeDuongSu updatedQuanHeDuongSu = quanHeDuongSuRepository.findById(quanHeDuongSu.getId()).orElseThrow();
        // Disconnect from session so that the updates on updatedQuanHeDuongSu are not directly saved in db
        em.detach(updatedQuanHeDuongSu);
        updatedQuanHeDuongSu
            .idDuongSu(UPDATED_ID_DUONG_SU)
            .idDuongSuQh(UPDATED_ID_DUONG_SU_QH)
            .idQuanHe(UPDATED_ID_QUAN_HE)
            .thongTinQuanHe(UPDATED_THONG_TIN_QUAN_HE)
            .trangThai(UPDATED_TRANG_THAI);
        QuanHeDuongSuDTO quanHeDuongSuDTO = quanHeDuongSuMapper.toDto(updatedQuanHeDuongSu);

        restQuanHeDuongSuMockMvc
            .perform(
                put(ENTITY_API_URL_ID, quanHeDuongSuDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(quanHeDuongSuDTO))
            )
            .andExpect(status().isOk());

        // Validate the QuanHeDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedQuanHeDuongSuToMatchAllProperties(updatedQuanHeDuongSu);
    }

    @Test
    @Transactional
    void putNonExistingQuanHeDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        quanHeDuongSu.setId(longCount.incrementAndGet());

        // Create the QuanHeDuongSu
        QuanHeDuongSuDTO quanHeDuongSuDTO = quanHeDuongSuMapper.toDto(quanHeDuongSu);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restQuanHeDuongSuMockMvc
            .perform(
                put(ENTITY_API_URL_ID, quanHeDuongSuDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(quanHeDuongSuDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the QuanHeDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchQuanHeDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        quanHeDuongSu.setId(longCount.incrementAndGet());

        // Create the QuanHeDuongSu
        QuanHeDuongSuDTO quanHeDuongSuDTO = quanHeDuongSuMapper.toDto(quanHeDuongSu);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restQuanHeDuongSuMockMvc
            .perform(
                put(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(om.writeValueAsBytes(quanHeDuongSuDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the QuanHeDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamQuanHeDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        quanHeDuongSu.setId(longCount.incrementAndGet());

        // Create the QuanHeDuongSu
        QuanHeDuongSuDTO quanHeDuongSuDTO = quanHeDuongSuMapper.toDto(quanHeDuongSu);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restQuanHeDuongSuMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(om.writeValueAsBytes(quanHeDuongSuDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the QuanHeDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateQuanHeDuongSuWithPatch() throws Exception {
        // Initialize the database
        insertedQuanHeDuongSu = quanHeDuongSuRepository.saveAndFlush(quanHeDuongSu);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the quanHeDuongSu using partial update
        QuanHeDuongSu partialUpdatedQuanHeDuongSu = new QuanHeDuongSu();
        partialUpdatedQuanHeDuongSu.setId(quanHeDuongSu.getId());

        partialUpdatedQuanHeDuongSu.idDuongSu(UPDATED_ID_DUONG_SU);

        restQuanHeDuongSuMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedQuanHeDuongSu.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedQuanHeDuongSu))
            )
            .andExpect(status().isOk());

        // Validate the QuanHeDuongSu in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertQuanHeDuongSuUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedQuanHeDuongSu, quanHeDuongSu),
            getPersistedQuanHeDuongSu(quanHeDuongSu)
        );
    }

    @Test
    @Transactional
    void fullUpdateQuanHeDuongSuWithPatch() throws Exception {
        // Initialize the database
        insertedQuanHeDuongSu = quanHeDuongSuRepository.saveAndFlush(quanHeDuongSu);

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the quanHeDuongSu using partial update
        QuanHeDuongSu partialUpdatedQuanHeDuongSu = new QuanHeDuongSu();
        partialUpdatedQuanHeDuongSu.setId(quanHeDuongSu.getId());

        partialUpdatedQuanHeDuongSu
            .idDuongSu(UPDATED_ID_DUONG_SU)
            .idDuongSuQh(UPDATED_ID_DUONG_SU_QH)
            .idQuanHe(UPDATED_ID_QUAN_HE)
            .thongTinQuanHe(UPDATED_THONG_TIN_QUAN_HE)
            .trangThai(UPDATED_TRANG_THAI);

        restQuanHeDuongSuMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedQuanHeDuongSu.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(partialUpdatedQuanHeDuongSu))
            )
            .andExpect(status().isOk());

        // Validate the QuanHeDuongSu in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertQuanHeDuongSuUpdatableFieldsEquals(partialUpdatedQuanHeDuongSu, getPersistedQuanHeDuongSu(partialUpdatedQuanHeDuongSu));
    }

    @Test
    @Transactional
    void patchNonExistingQuanHeDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        quanHeDuongSu.setId(longCount.incrementAndGet());

        // Create the QuanHeDuongSu
        QuanHeDuongSuDTO quanHeDuongSuDTO = quanHeDuongSuMapper.toDto(quanHeDuongSu);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restQuanHeDuongSuMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, quanHeDuongSuDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(quanHeDuongSuDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the QuanHeDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchQuanHeDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        quanHeDuongSu.setId(longCount.incrementAndGet());

        // Create the QuanHeDuongSu
        QuanHeDuongSuDTO quanHeDuongSuDTO = quanHeDuongSuMapper.toDto(quanHeDuongSu);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restQuanHeDuongSuMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, longCount.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(om.writeValueAsBytes(quanHeDuongSuDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the QuanHeDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamQuanHeDuongSu() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        quanHeDuongSu.setId(longCount.incrementAndGet());

        // Create the QuanHeDuongSu
        QuanHeDuongSuDTO quanHeDuongSuDTO = quanHeDuongSuMapper.toDto(quanHeDuongSu);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restQuanHeDuongSuMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(om.writeValueAsBytes(quanHeDuongSuDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the QuanHeDuongSu in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteQuanHeDuongSu() throws Exception {
        // Initialize the database
        insertedQuanHeDuongSu = quanHeDuongSuRepository.saveAndFlush(quanHeDuongSu);

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the quanHeDuongSu
        restQuanHeDuongSuMockMvc
            .perform(delete(ENTITY_API_URL_ID, quanHeDuongSu.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return quanHeDuongSuRepository.count();
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

    protected QuanHeDuongSu getPersistedQuanHeDuongSu(QuanHeDuongSu quanHeDuongSu) {
        return quanHeDuongSuRepository.findById(quanHeDuongSu.getId()).orElseThrow();
    }

    protected void assertPersistedQuanHeDuongSuToMatchAllProperties(QuanHeDuongSu expectedQuanHeDuongSu) {
        assertQuanHeDuongSuAllPropertiesEquals(expectedQuanHeDuongSu, getPersistedQuanHeDuongSu(expectedQuanHeDuongSu));
    }

    protected void assertPersistedQuanHeDuongSuToMatchUpdatableProperties(QuanHeDuongSu expectedQuanHeDuongSu) {
        assertQuanHeDuongSuAllUpdatablePropertiesEquals(expectedQuanHeDuongSu, getPersistedQuanHeDuongSu(expectedQuanHeDuongSu));
    }
}
