package vn.vnpt.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;
import vn.vnpt.repository.QuanHeNhanThanRepository;
import vn.vnpt.service.QuanHeNhanThanService;
import vn.vnpt.service.dto.QuanHeNhanThanDTO;
import vn.vnpt.web.rest.errors.BadRequestAlertException;

/**
 * REST controller for managing {@link vn.vnpt.domain.QuanHeNhanThan}.
 */
@RestController
@RequestMapping("/api/quan-he-nhan-thans")
public class QuanHeNhanThanResource {

    private static final Logger log = LoggerFactory.getLogger(QuanHeNhanThanResource.class);

    private static final String ENTITY_NAME = "duongSuQuanHeNhanThan";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final QuanHeNhanThanService quanHeNhanThanService;

    private final QuanHeNhanThanRepository quanHeNhanThanRepository;

    public QuanHeNhanThanResource(QuanHeNhanThanService quanHeNhanThanService, QuanHeNhanThanRepository quanHeNhanThanRepository) {
        this.quanHeNhanThanService = quanHeNhanThanService;
        this.quanHeNhanThanRepository = quanHeNhanThanRepository;
    }

    /**
     * {@code POST  /quan-he-nhan-thans} : Create a new quanHeNhanThan.
     *
     * @param quanHeNhanThanDTO the quanHeNhanThanDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new quanHeNhanThanDTO, or with status {@code 400 (Bad Request)} if the quanHeNhanThan has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<QuanHeNhanThanDTO> createQuanHeNhanThan(@RequestBody QuanHeNhanThanDTO quanHeNhanThanDTO)
        throws URISyntaxException {
        log.debug("REST request to save QuanHeNhanThan : {}", quanHeNhanThanDTO);
        if (quanHeNhanThanDTO.getId() != null) {
            throw new BadRequestAlertException("A new quanHeNhanThan cannot already have an ID", ENTITY_NAME, "idexists");
        }
        quanHeNhanThanDTO = quanHeNhanThanService.save(quanHeNhanThanDTO);
        return ResponseEntity.created(new URI("/api/quan-he-nhan-thans/" + quanHeNhanThanDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, quanHeNhanThanDTO.getId().toString()))
            .body(quanHeNhanThanDTO);
    }

    /**
     * {@code PUT  /quan-he-nhan-thans/:id} : Updates an existing quanHeNhanThan.
     *
     * @param id the id of the quanHeNhanThanDTO to save.
     * @param quanHeNhanThanDTO the quanHeNhanThanDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated quanHeNhanThanDTO,
     * or with status {@code 400 (Bad Request)} if the quanHeNhanThanDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the quanHeNhanThanDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<QuanHeNhanThanDTO> updateQuanHeNhanThan(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody QuanHeNhanThanDTO quanHeNhanThanDTO
    ) throws URISyntaxException {
        log.debug("REST request to update QuanHeNhanThan : {}, {}", id, quanHeNhanThanDTO);
        if (quanHeNhanThanDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, quanHeNhanThanDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!quanHeNhanThanRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        quanHeNhanThanDTO = quanHeNhanThanService.update(quanHeNhanThanDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, quanHeNhanThanDTO.getId().toString()))
            .body(quanHeNhanThanDTO);
    }

    /**
     * {@code PATCH  /quan-he-nhan-thans/:id} : Partial updates given fields of an existing quanHeNhanThan, field will ignore if it is null
     *
     * @param id the id of the quanHeNhanThanDTO to save.
     * @param quanHeNhanThanDTO the quanHeNhanThanDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated quanHeNhanThanDTO,
     * or with status {@code 400 (Bad Request)} if the quanHeNhanThanDTO is not valid,
     * or with status {@code 404 (Not Found)} if the quanHeNhanThanDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the quanHeNhanThanDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<QuanHeNhanThanDTO> partialUpdateQuanHeNhanThan(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody QuanHeNhanThanDTO quanHeNhanThanDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update QuanHeNhanThan partially : {}, {}", id, quanHeNhanThanDTO);
        if (quanHeNhanThanDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, quanHeNhanThanDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!quanHeNhanThanRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<QuanHeNhanThanDTO> result = quanHeNhanThanService.partialUpdate(quanHeNhanThanDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, quanHeNhanThanDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /quan-he-nhan-thans} : get all the quanHeNhanThans.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of quanHeNhanThans in body.
     */
    @GetMapping("")
    public ResponseEntity<List<QuanHeNhanThanDTO>> getAllQuanHeNhanThans(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        log.debug("REST request to get a page of QuanHeNhanThans");
        Page<QuanHeNhanThanDTO> page = quanHeNhanThanService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /quan-he-nhan-thans/:id} : get the "id" quanHeNhanThan.
     *
     * @param id the id of the quanHeNhanThanDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the quanHeNhanThanDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<QuanHeNhanThanDTO> getQuanHeNhanThan(@PathVariable("id") Long id) {
        log.debug("REST request to get QuanHeNhanThan : {}", id);
        Optional<QuanHeNhanThanDTO> quanHeNhanThanDTO = quanHeNhanThanService.findOne(id);
        return ResponseUtil.wrapOrNotFound(quanHeNhanThanDTO);
    }

    /**
     * {@code DELETE  /quan-he-nhan-thans/:id} : delete the "id" quanHeNhanThan.
     *
     * @param id the id of the quanHeNhanThanDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuanHeNhanThan(@PathVariable("id") Long id) {
        log.debug("REST request to delete QuanHeNhanThan : {}", id);
        quanHeNhanThanService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
