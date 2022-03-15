package co.edu.javeriana.proyectoWeb.model;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/monster_type")
public class MonsterTypeController 
{   
    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    MonsterTypeRepository monsterTypeRepository;

    @Autowired 
    MonsterRepository monsterRepository;

    @GetMapping("/list")
    public String monsterTypeList(Model model)
    {
        Iterable<MonsterType> monsterTypes = monsterTypeRepository.findAll();
        model.addAttribute("monsterTypes", monsterTypes);
        return "monsterType-list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) throws NotFoundException 
    {
        Optional<MonsterType> p = monsterTypeRepository.findById(id);
        
        if (p != null) 
        {
            model.addAttribute("monsterType", p);
            return "monsterType-edit";
        } 
        else 
        {
            throw new NotFoundException();
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id)
    {
        MonsterType monsterType=monsterTypeRepository.findById(id).get();
        for ( Monster monster : monsterType.getMonsters()){
            Room r = monster.getIdRoom();
            monster.unlinkMonster(r);
            monsterRepository.delete(monster);
        }
        monsterTypeRepository.deleteById(id);
        return "redirect:/monster_type/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MonsterType monsterType, Model model) 
    {
        monsterTypeRepository.save(monsterType);
        return "redirect:/monster_type/list";
    }
}
