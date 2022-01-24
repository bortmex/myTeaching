package com.rog.teach.controller.helpers;

import com.rog.teach.entity.ProjectEntity;
import com.rog.teach.repositories.ProjectRepository;
import javassist.NotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
@Transactional
public class ControllerHelper {

    ProjectRepository projectRepository;

    public ProjectEntity getProjectOrThrowException(Long projectId) {

        ProjectEntity projectEntity = null;
        try {
            projectEntity = projectRepository
                    .findById(projectId)
                    .orElseThrow(() ->
                            new NotFoundException(
                                    String.format(
                                            "Project with \"%s\" doesn't exist.",
                                            projectId
                                    )
                            )
                    );
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return projectEntity;
    }
}