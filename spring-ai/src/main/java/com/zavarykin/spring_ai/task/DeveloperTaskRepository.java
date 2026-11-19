package com.zavarykin.spring_ai.task;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeveloperTaskRepository {

    private final JdbcClient jdbcClient;

    public DeveloperTaskRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<DeveloperTask> findByStatus(String status) {
        return jdbcClient.sql("""
                SELECT id, title, description, status
                FROM lab_tasks.developer_tasks
                WHERE status = :status
                ORDER BY id
                LIMIT 20
                """)
                .param("status", status)
                .query((rs, rowNum) -> new DeveloperTask(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status")
                ))
                .list();
    }
}

