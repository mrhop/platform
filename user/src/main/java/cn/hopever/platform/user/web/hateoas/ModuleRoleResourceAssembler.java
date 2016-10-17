package cn.hopever.platform.user.web.hateoas;

import cn.hopever.platform.user.domain.ModuleRoleTable;
import cn.hopever.platform.user.domain.ModuleTable;
import cn.hopever.platform.user.resources.ClientResource;
import cn.hopever.platform.user.resources.ModuleResource;
import cn.hopever.platform.user.resources.ModuleRoleResource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Donghui Huo on 2016/9/1.
 */
@Component
public class ModuleRoleResourceAssembler extends ResourceAssemblerSupport<ModuleRoleTable, ModuleRoleResource> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    EntityLinks entityLinks;

    public ModuleRoleResourceAssembler() {
        super(ModuleRoleResourceController.class, ModuleRoleResource.class);
    }

    @Override
    public ModuleRoleResource toResource(ModuleRoleTable moduleRoleTable) {
        ModuleRoleResource resource = createResource(moduleRoleTable);
        if (moduleRoleTable.getModules() != null) {
            Set<ModuleResource> setMr = new LinkedHashSet<>();
            for (ModuleTable mt : moduleRoleTable.getModules()) {
                ModuleResource moduleResource = new ModuleResource();
                moduleResource.setInternalId(mt.getId());
                moduleResource.setModuleName(mt.getModuleName());
                setMr.add(moduleResource);
            }
            resource.setModules(setMr);
        }
        return resource;
    }

    public List<ModuleRoleResource> toResourcesCustomized(Iterable<ModuleRoleTable> moduleRoleTables) {
        List<ModuleRoleResource> returnList = new ArrayList<>();
        for (ModuleRoleTable mrt : moduleRoleTables) {
            returnList.add(this.createResource(mrt));
        }
        return returnList;
    }

    private ModuleRoleResource createResource(ModuleRoleTable moduleRoleTable) {
        ModuleRoleResource moduleRoleResource = null;
        if (moduleRoleTable != null) {
            moduleRoleResource = modelMapper.map(moduleRoleTable, ModuleRoleResource.class);
            moduleRoleResource.setInternalId(moduleRoleTable.getId());
            moduleRoleResource.add(entityLinks.linkFor(ClientResource.class).slash(moduleRoleTable.getId()).withSelfRel());
        }
        return moduleRoleResource;
    }
}
