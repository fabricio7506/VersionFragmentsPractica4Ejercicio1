/**
 * Descripción: Actividad principal que maneja los Fragments
 * Autor: Assistant
 * Fecha creación: 24/09/2024
 * Fecha última modificación: 24/09/2024
 */

// Descripción: Interacción con Imágenes versión Fragments.
// Autor: Fabricio Gabriel Carrazco Arana
// Fecha de creación: 21/09/2024
// Última modificación: 24/09/2024

package com.example.seagradece

import android.app.Activity
import android.os.Bundle

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            showMainFragment()
        }
    }

    fun showMainFragment() {
        fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, MainFragment())
            .commit()
    }

    fun showImageFragment(selectedImage: String) {
        fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, ImageFragment.newInstance(selectedImage))
            .addToBackStack(null)
            .commit()
    }
}