package vn.vnpt.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class TinhTrangDuongSuAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertTinhTrangDuongSuAllPropertiesEquals(TinhTrangDuongSu expected, TinhTrangDuongSu actual) {
        assertTinhTrangDuongSuAutoGeneratedPropertiesEquals(expected, actual);
        assertTinhTrangDuongSuAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertTinhTrangDuongSuAllUpdatablePropertiesEquals(TinhTrangDuongSu expected, TinhTrangDuongSu actual) {
        assertTinhTrangDuongSuUpdatableFieldsEquals(expected, actual);
        assertTinhTrangDuongSuUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertTinhTrangDuongSuAutoGeneratedPropertiesEquals(TinhTrangDuongSu expected, TinhTrangDuongSu actual) {
        assertThat(expected)
            .as("Verify TinhTrangDuongSu auto generated properties")
            .satisfies(e -> assertThat(e.getId()).as("check id").isEqualTo(actual.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertTinhTrangDuongSuUpdatableFieldsEquals(TinhTrangDuongSu expected, TinhTrangDuongSu actual) {
        assertThat(expected)
            .as("Verify TinhTrangDuongSu relevant properties")
            .satisfies(e -> assertThat(e.getIdTinhTrang()).as("check idTinhTrang").isEqualTo(actual.getIdTinhTrang()))
            .satisfies(e -> assertThat(e.getDienGiai()).as("check dienGiai").isEqualTo(actual.getDienGiai()))
            .satisfies(e -> assertThat(e.getIdLoaiDs()).as("check idLoaiDs").isEqualTo(actual.getIdLoaiDs()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertTinhTrangDuongSuUpdatableRelationshipsEquals(TinhTrangDuongSu expected, TinhTrangDuongSu actual) {}
}