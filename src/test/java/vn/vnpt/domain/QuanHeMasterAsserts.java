package vn.vnpt.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class QuanHeMasterAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertQuanHeMasterAllPropertiesEquals(QuanHeMaster expected, QuanHeMaster actual) {
        assertQuanHeMasterAutoGeneratedPropertiesEquals(expected, actual);
        assertQuanHeMasterAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertQuanHeMasterAllUpdatablePropertiesEquals(QuanHeMaster expected, QuanHeMaster actual) {
        assertQuanHeMasterUpdatableFieldsEquals(expected, actual);
        assertQuanHeMasterUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertQuanHeMasterAutoGeneratedPropertiesEquals(QuanHeMaster expected, QuanHeMaster actual) {
        assertThat(expected)
            .as("Verify QuanHeMaster auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertQuanHeMasterUpdatableFieldsEquals(QuanHeMaster expected, QuanHeMaster actual) {
        assertThat(expected)
            .as("Verify QuanHeMaster relevant properties")
            .satisfies(e -> assertThat(e.getIdDuongSu()).as("check idDuongSu").isEqualTo(actual.getIdDuongSu()))
            .satisfies(e -> assertThat(e.getIdDuongSuQh()).as("check idDuongSuQh").isEqualTo(actual.getIdDuongSuQh()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertQuanHeMasterUpdatableRelationshipsEquals(QuanHeMaster expected, QuanHeMaster actual) {}
}
