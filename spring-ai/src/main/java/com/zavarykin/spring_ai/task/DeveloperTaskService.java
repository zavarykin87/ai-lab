package com.zavarykin.spring_ai.task;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
public class DeveloperTaskService {

    private static final Set<String> ALLOWED_STATUSES = Set.of("TODO", "IN_PROGRESS", "DONE");

    private final DeveloperTaskRepository repository;

    public DeveloperTaskService(DeveloperTaskRepository repository) {
        this.repository = repository;
    }

    public List<DeveloperTask> findByStatus(String status) {

        if (status == null) {
            throw new IllegalArgumentException("Task status is required");
        }
        
        String normalized = status.trim()
                .toUpperCase(Locale.ROOT)
                .replace(' ', '_')
                .replace('-', '_');

        if (!ALLOWED_STATUSES.contains(normalized)) {
            throw new IllegalArgumentException(
                    "Unsupported task status: " + status
            );
        }

        return repository.findByStatus(normalized);
    }
}

