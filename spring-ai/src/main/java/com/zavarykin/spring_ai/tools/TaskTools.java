package com.zavarykin.spring_ai.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import com.zavarykin.spring_ai.task.DeveloperTask;
import com.zavarykin.spring_ai.task.DeveloperTaskService;

import java.util.List;

@Component
public class TaskTools {

    private static final Logger log = LoggerFactory.getLogger(TaskTools.class);
    private final DeveloperTaskService taskService;

    public TaskTools(DeveloperTaskService taskService) {
        this.taskService = taskService;
    }

    @Tool(
        name = "findTasksByStatus",
        description = """
            Find developer tasks in the database by status.
            Allowed statuses: TODO, IN_PROGRESS, DONE.
            Returns up to 20 matching tasks.
            Use this tool when the user asks about
            task progress, pending or completed tasks.
            """
    )
    public List<DeveloperTask> findTasksByStatus(
        @ToolParam(
            description = "Task status: TODO, IN_PROGRESS or DONE"
        ) String status
    ) {
        log.info("Tool called: findTasksByStatus({})", status);

        return taskService.findByStatus(status);
    }
}
