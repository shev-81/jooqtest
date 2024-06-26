/*
 * This file is generated by jOOQ.
 */
package com.example.jooqtest.domain;


import org.jooq.Sequence;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * Convenience access to all sequences in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.batch_job_execution_seq</code>
     */
    public static final Sequence<Long> BATCH_JOB_EXECUTION_SEQ = Internal.createSequence("batch_job_execution_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.batch_job_seq</code>
     */
    public static final Sequence<Long> BATCH_JOB_SEQ = Internal.createSequence("batch_job_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>public.batch_step_execution_seq</code>
     */
    public static final Sequence<Long> BATCH_STEP_EXECUTION_SEQ = Internal.createSequence("batch_step_execution_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, null, null, null, false, null);
}
