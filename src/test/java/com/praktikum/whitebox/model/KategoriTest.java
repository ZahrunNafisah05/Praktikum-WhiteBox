package com.praktikum.whitebox.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KategoriTest {
    @Test
    @DisplayName("Test constructor default dan parameter")
    void testConstructors() {
        // Default constructor
        Kategori k1 = new Kategori();
        assertNull(k1.getKode());
        assertNull(k1.getNama());
        assertNull(k1.getDeskripsi());
        assertFalse(k1.isAktif()); // default boolean = false

        // Constructor dengan parameter
        Kategori k2 = new Kategori("KTG01", "Nama", "Deskripsi");
        assertEquals("KTG01", k2.getKode());
        assertEquals("Nama", k2.getNama());
        assertEquals("Deskripsi", k2.getDeskripsi());
        assertTrue(k2.isAktif()); // default aktif = true
    }

    @Test
    @DisplayName("Test getter dan setter")
    void testGettersAndSetters() {
        Kategori k = new Kategori();
        k.setKode("KTG02");
        k.setNama("Kategori Test");
        k.setDeskripsi("Deskripsi Test");
        k.setAktif(true);

        assertEquals("KTG02", k.getKode());
        assertEquals("Kategori Test", k.getNama());
        assertEquals("Deskripsi Test", k.getDeskripsi());
        assertTrue(k.isAktif());
    }

    @Test
    @DisplayName("Test equals method untuk semua branch")
    void testEquals() {
        Kategori k1 = new Kategori("KTG01", "Nama1", "Desk1");
        Kategori k2 = new Kategori("KTG01", "Nama2", "Desk2");
        Kategori k3 = new Kategori("KTG02", "Nama3", "Desk3");

        // this == o
        assertTrue(k1.equals(k1));

        // o == null
        assertFalse(k1.equals(null));

        // o beda class
        assertFalse(k1.equals("string"));

        // kode sama → true (walau nama/deskripsi beda)
        assertTrue(k1.equals(k2));

        // kode beda → false
        assertFalse(k1.equals(k3));
    }

    @Test
    @DisplayName("Test hashCode konsisten dengan equals")
    void testHashCode() {
        Kategori k1 = new Kategori("KTG01", "Nama", "Desk");
        Kategori k2 = new Kategori("KTG01", "Nama Lain", "Desk Lain");

        assertEquals(k1.hashCode(), k2.hashCode()); // karena kode sama
    }

    @Test
    @DisplayName("Test toString menghasilkan format yang benar")
    void testToString() {
        Kategori k = new Kategori("KTG01", "Nama", "Desk");
        String result = k.toString();

        assertTrue(result.contains("KTG01"));
        assertTrue(result.contains("Nama"));
        assertTrue(result.contains("Desk"));
        assertTrue(result.contains("true"));
    }
}
