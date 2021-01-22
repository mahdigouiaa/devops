package tn.iit.storemanagement.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import tn.iit.storemanagement.dto.MedicamentDto;
import tn.iit.storemanagement.service.MedicamentService;


import java.util.Collection;
import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/medicaments")
@RestController()
public class MedicamentResource {
    private final MedicamentService medicamentService;
    @Autowired
    public MedicamentResource(MedicamentService medicamentService) {
        this.medicamentService = medicamentService;
    }

    @GetMapping("/{id}")
    public MedicamentDto findOne(@PathVariable("id") long id) {
        return this.medicamentService.findOne (id);
    }

    @GetMapping()
    public Collection<MedicamentDto> findAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String pageSort
    ) {
        return this.medicamentService.findAll (PageRequest.of(pageNo,pageSize, Sort.by (pageSort).ascending ()));
    }

    @PostMapping
    public MedicamentDto add(@RequestBody MedicamentDto medicamentDto) {

        return this.medicamentService.save (medicamentDto);
    }

    @PostMapping("/searches")
    public Collection<MedicamentDto> searches(@RequestBody List<Long> ids){
        return this.medicamentService.findAllByIds(ids);
    }

    @PutMapping()
    public MedicamentDto update(@RequestBody MedicamentDto medicamentDto) {
        return this.medicamentService.save (medicamentDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        this.medicamentService.deleteById (id);
    }
}
