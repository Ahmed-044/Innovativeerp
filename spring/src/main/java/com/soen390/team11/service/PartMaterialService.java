package com.soen390.team11.service;

import com.soen390.team11.dto.PartMaterialResponse;
import com.soen390.team11.entity.Material;
import com.soen390.team11.entity.PartMaterial;
import com.soen390.team11.entity.Product;
import com.soen390.team11.entity.ProductInventory;
import com.soen390.team11.repository.MaterialRepository;
import com.soen390.team11.repository.PartMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PartMaterialService {

    @Autowired
    PartMaterialRepository partMaterialRepository;
    @Autowired
    MaterialRepository materialRepository;

    public Map<String, Integer> getPartMaterials(String part_id) {
        Map<String, Integer> materialMap = new HashMap<>();
        partMaterialRepository.findAllByPart_id(part_id).forEach(
                partInventory -> materialMap.put(partInventory.getMaterialId(), partInventory.getMaterial_quantity()));
        return materialMap;
    }

    public List<PartMaterialResponse> getAllMaterialsOfPart(String part_id) {
        List<PartMaterial> partMaterialList = partMaterialRepository.findAllByPart_id(part_id);
        List<Material> materials = (List<Material>) materialRepository.findAll();
        List<PartMaterialResponse> PartMaterialResponselist = new ArrayList<>();
        PartMaterialResponse partMaterialResponse = new PartMaterialResponse();
        for (PartMaterial pm : partMaterialList) {
            for (Material m : materials) {
                if (pm.getMaterialId().equals(m.getMaterialid())) {
                    partMaterialResponse = new PartMaterialResponse(pm.getId(), pm.getPartId(), pm.getMaterialId(),
                            pm.getMaterial_quantity(), m.getName());
                }
            }
            PartMaterialResponselist.add(partMaterialResponse);
        }
        return PartMaterialResponselist;
    }

}
