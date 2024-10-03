/**
 * Descripción: Fragment principal para la selección de imágenes
 * Autor: Assistant
 * Fecha creación: 24/09/2024
 * Fecha última modificación: 24/09/2024
 */
// Descripción: Interacción con Imágenes versión Fragments.
// Autor: Fabricio Gabriel Carrazco Arana
// Fecha de creación: 21/09/2024
// Última modificación: 24/09/2024
package com.example.seagradece

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class MainFragment : Fragment() {
    private lateinit var spinner: Spinner
    private lateinit var nextButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        spinner = view.findViewById(R.id.imageSpinner)
        nextButton = view.findViewById(R.id.nextButton)

        val images = arrayOf("Montaña", "Playa", "Bosque", "Ciudad", "Desierto")
        val adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_item, images)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        nextButton.setOnClickListener {
            val selectedImage = spinner.selectedItem.toString()
            (activity as? MainActivity)?.showImageFragment(selectedImage)
        }

        return view
    }
}