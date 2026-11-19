CREATE TABLE lab_tasks.developer_tasks (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description TEXT NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('TODO', 'IN_PROGRESS', 'DONE')),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_developer_tasks_status ON lab_tasks.developer_tasks(status);

INSERT INTO lab_tasks.developer_tasks (title, description, status) 
VALUES
    (
        'Implement Chat Memory',
        'Store conversation history in PostgreSQL',
        'DONE'
    ),
    (
        'Implement SSE Streaming',
        'Stream LLM responses to the client',
        'DONE'
    ),
    (
        'Implement Tool Calling',
        'Integrate Java methods with Spring AI',
        'IN_PROGRESS'
    ),
    (
        'Implement RAG',
        'Add document retrieval using vector search',
        'TODO'
    );
