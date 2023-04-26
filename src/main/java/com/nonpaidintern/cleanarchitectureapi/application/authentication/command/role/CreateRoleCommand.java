package com.nonpaidintern.cleanarchitectureapi.application.authentication.command.role;

import com.nonpaidintern.cleanarchitectureapi.application.authentication.common.CreateRoleDTO;
import com.nonpaidintern.cleanarchitectureapi.application.common.service.RoleService;
import com.nonpaidintern.cleanarchitectureapi.domain.user.Role;
import io.jkratz.mediator.core.Command;
import io.jkratz.mediator.core.CommandHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoleCommand implements Command {

    private String roleName;

    @Service
    static class CreateRoleCommandHandler implements CommandHandler<CreateRoleCommand> {

        private final RoleService roleService;

        @Autowired
        CreateRoleCommandHandler(RoleService roleService) {
            this.roleService = roleService;
        }

        @Override
        public void handle(CreateRoleCommand command) {

            Role role = new Role();
            role.setName(command.roleName);

            roleService.save(new CreateRoleDTO(role));
        }
    }
}
