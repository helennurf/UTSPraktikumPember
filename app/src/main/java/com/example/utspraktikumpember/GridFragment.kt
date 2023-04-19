package com.example.utspraktikumpember

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridFragment : Fragment() {

    private val list = ArrayList<Mahasiswa>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view1 = inflater.inflate(R.layout.fragment_grid, container, false)

        list.addAll(getDataMahasiswa())

        val recyclerView1 = view1.findViewById<RecyclerView>(R.id.rvMahasiswa1)
        recyclerView1.layoutManager = GridLayoutManager(requireContext(), 2)

        val adapter = ListMahasiswa(list)
        recyclerView1.adapter = adapter
        recyclerView1.setHasFixedSize(true)

        return view1
    }

    private fun getDataMahasiswa(): ArrayList<Mahasiswa> {
        val dataNama = resources.getStringArray(R.array.mahasiswa_nama)
        val dataNIM = resources.getStringArray(R.array.mahasiswa_nim)
        val dataUmur = resources.getStringArray(R.array.mahasiswa_umur)
        val dataFoto = resources.obtainTypedArray(R.array.mahasiswa_foto)
        val listData = ArrayList<Mahasiswa>()
        for (i in dataNama.indices) {
            val mahasiswa = Mahasiswa(dataNama[i], dataNIM[i], dataUmur[i], dataFoto.getResourceId(i, 0))
            listData.add(mahasiswa)
        }
        return listData

    }
}