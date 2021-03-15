package com.soen390.team11.service;

import com.soen390.team11.dto.PartMaterialResponse;
import com.soen390.team11.entity.Material;
import com.soen390.team11.entity.PartMaterial;
import com.soen390.team11.repository.MaterialRepository;
import com.soen390.team11.repository.PartMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service Layer for Part's Material
 */
@Service
public class PartMaterialService {

    @Autowired
    PartMaterialRepository partMaterialRepository;
    @Autowired
    MaterialRepository materialRepository;

    /**
     * Map of all parts' materials and their quantity
     *
     * @param partId The part's ID
     * @return Map of all materials' and their quantity
     */
    public Map<String, Integer> getPartMaterials(String partId) {
        Map<String, Integer> materialMap = new HashMap<>();
        partMaterialRepository.findAllByPartId(partId).forEach(
                partInventory -> materialMap.put(partInventory.getMaterialId(), partInventory.getmaterialQuantity()));
        return materialMap;
    }

    /**
     * Gets all Materials of a Part
     *
     * @param partId The Part
     * @return The Part's materials
     */
    public List<PartMaterialResponse> getAllMaterialsOfPart(String partId) {
        List<PartMaterial> partMaterialList = partMaterialRepository.findAllByPartId(partId);
        List<Material> materials = (List<Material>) materialRepository.findAll();
        List<PartMaterialResponse> PartMaterialResponselist = new ArrayList<>();
        PartMaterialResponse partMaterialResponse = new PartMaterialResponse();
        for (PartMaterial pm : partMaterialList) {
            for (Material m : materials) {
                if (pm.getMaterialId().equals(m.getMaterialid())) {
                    partMaterialResponse = new PartMaterialResponse(pm.getId(), pm.getPartId(), pm.getMaterialId(),
                            pm.getmaterialQuantity(), m.getName());
                }
            }
            PartMaterialResponselist.add(partMaterialResponse);
        }
        return PartMaterialResponselist;
    }

}
