/*
 * This file is generated by jOOQ.
 */
package com.example.jooqtest.domain;


import com.example.jooqtest.domain.tables.BatchJobExecution;
import com.example.jooqtest.domain.tables.BatchJobExecutionContext;
import com.example.jooqtest.domain.tables.BatchJobExecutionParams;
import com.example.jooqtest.domain.tables.BatchJobInstance;
import com.example.jooqtest.domain.tables.BatchStepExecution;
import com.example.jooqtest.domain.tables.BatchStepExecutionContext;
import com.example.jooqtest.domain.tables.Categories;
import com.example.jooqtest.domain.tables.Products;
import com.example.jooqtest.domain.tables.records.BatchJobExecutionContextRecord;
import com.example.jooqtest.domain.tables.records.BatchJobExecutionParamsRecord;
import com.example.jooqtest.domain.tables.records.BatchJobExecutionRecord;
import com.example.jooqtest.domain.tables.records.BatchJobInstanceRecord;
import com.example.jooqtest.domain.tables.records.BatchStepExecutionContextRecord;
import com.example.jooqtest.domain.tables.records.BatchStepExecutionRecord;
import com.example.jooqtest.domain.tables.records.CategoriesRecord;
import com.example.jooqtest.domain.tables.records.ProductsRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<BatchJobExecutionRecord> BATCH_JOB_EXECUTION_PKEY = Internal.createUniqueKey(BatchJobExecution.BATCH_JOB_EXECUTION, DSL.name("batch_job_execution_pkey"), new TableField[] { BatchJobExecution.BATCH_JOB_EXECUTION.JOB_EXECUTION_ID }, true);
    public static final UniqueKey<BatchJobExecutionContextRecord> BATCH_JOB_EXECUTION_CONTEXT_PKEY = Internal.createUniqueKey(BatchJobExecutionContext.BATCH_JOB_EXECUTION_CONTEXT, DSL.name("batch_job_execution_context_pkey"), new TableField[] { BatchJobExecutionContext.BATCH_JOB_EXECUTION_CONTEXT.JOB_EXECUTION_ID }, true);
    public static final UniqueKey<BatchJobInstanceRecord> BATCH_JOB_INSTANCE_PKEY = Internal.createUniqueKey(BatchJobInstance.BATCH_JOB_INSTANCE, DSL.name("batch_job_instance_pkey"), new TableField[] { BatchJobInstance.BATCH_JOB_INSTANCE.JOB_INSTANCE_ID }, true);
    public static final UniqueKey<BatchJobInstanceRecord> JOB_INST_UN = Internal.createUniqueKey(BatchJobInstance.BATCH_JOB_INSTANCE, DSL.name("job_inst_un"), new TableField[] { BatchJobInstance.BATCH_JOB_INSTANCE.JOB_NAME, BatchJobInstance.BATCH_JOB_INSTANCE.JOB_KEY }, true);
    public static final UniqueKey<BatchStepExecutionRecord> BATCH_STEP_EXECUTION_PKEY = Internal.createUniqueKey(BatchStepExecution.BATCH_STEP_EXECUTION, DSL.name("batch_step_execution_pkey"), new TableField[] { BatchStepExecution.BATCH_STEP_EXECUTION.STEP_EXECUTION_ID }, true);
    public static final UniqueKey<BatchStepExecutionContextRecord> BATCH_STEP_EXECUTION_CONTEXT_PKEY = Internal.createUniqueKey(BatchStepExecutionContext.BATCH_STEP_EXECUTION_CONTEXT, DSL.name("batch_step_execution_context_pkey"), new TableField[] { BatchStepExecutionContext.BATCH_STEP_EXECUTION_CONTEXT.STEP_EXECUTION_ID }, true);
    public static final UniqueKey<CategoriesRecord> CATEGORIES_PKEY = Internal.createUniqueKey(Categories.CATEGORIES, DSL.name("categories_pkey"), new TableField[] { Categories.CATEGORIES.ID }, true);
    public static final UniqueKey<ProductsRecord> PRODUCTS_PKEY = Internal.createUniqueKey(Products.PRODUCTS, DSL.name("products_pkey"), new TableField[] { Products.PRODUCTS.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<BatchJobExecutionRecord, BatchJobInstanceRecord> BATCH_JOB_EXECUTION__JOB_INST_EXEC_FK = Internal.createForeignKey(BatchJobExecution.BATCH_JOB_EXECUTION, DSL.name("job_inst_exec_fk"), new TableField[] { BatchJobExecution.BATCH_JOB_EXECUTION.JOB_INSTANCE_ID }, Keys.BATCH_JOB_INSTANCE_PKEY, new TableField[] { BatchJobInstance.BATCH_JOB_INSTANCE.JOB_INSTANCE_ID }, true);
    public static final ForeignKey<BatchJobExecutionContextRecord, BatchJobExecutionRecord> BATCH_JOB_EXECUTION_CONTEXT__JOB_EXEC_CTX_FK = Internal.createForeignKey(BatchJobExecutionContext.BATCH_JOB_EXECUTION_CONTEXT, DSL.name("job_exec_ctx_fk"), new TableField[] { BatchJobExecutionContext.BATCH_JOB_EXECUTION_CONTEXT.JOB_EXECUTION_ID }, Keys.BATCH_JOB_EXECUTION_PKEY, new TableField[] { BatchJobExecution.BATCH_JOB_EXECUTION.JOB_EXECUTION_ID }, true);
    public static final ForeignKey<BatchJobExecutionParamsRecord, BatchJobExecutionRecord> BATCH_JOB_EXECUTION_PARAMS__JOB_EXEC_PARAMS_FK = Internal.createForeignKey(BatchJobExecutionParams.BATCH_JOB_EXECUTION_PARAMS, DSL.name("job_exec_params_fk"), new TableField[] { BatchJobExecutionParams.BATCH_JOB_EXECUTION_PARAMS.JOB_EXECUTION_ID }, Keys.BATCH_JOB_EXECUTION_PKEY, new TableField[] { BatchJobExecution.BATCH_JOB_EXECUTION.JOB_EXECUTION_ID }, true);
    public static final ForeignKey<BatchStepExecutionRecord, BatchJobExecutionRecord> BATCH_STEP_EXECUTION__JOB_EXEC_STEP_FK = Internal.createForeignKey(BatchStepExecution.BATCH_STEP_EXECUTION, DSL.name("job_exec_step_fk"), new TableField[] { BatchStepExecution.BATCH_STEP_EXECUTION.JOB_EXECUTION_ID }, Keys.BATCH_JOB_EXECUTION_PKEY, new TableField[] { BatchJobExecution.BATCH_JOB_EXECUTION.JOB_EXECUTION_ID }, true);
    public static final ForeignKey<BatchStepExecutionContextRecord, BatchStepExecutionRecord> BATCH_STEP_EXECUTION_CONTEXT__STEP_EXEC_CTX_FK = Internal.createForeignKey(BatchStepExecutionContext.BATCH_STEP_EXECUTION_CONTEXT, DSL.name("step_exec_ctx_fk"), new TableField[] { BatchStepExecutionContext.BATCH_STEP_EXECUTION_CONTEXT.STEP_EXECUTION_ID }, Keys.BATCH_STEP_EXECUTION_PKEY, new TableField[] { BatchStepExecution.BATCH_STEP_EXECUTION.STEP_EXECUTION_ID }, true);
    public static final ForeignKey<ProductsRecord, CategoriesRecord> PRODUCTS__PRODUCTS_CATEGORY_ID_FKEY = Internal.createForeignKey(Products.PRODUCTS, DSL.name("products_category_id_fkey"), new TableField[] { Products.PRODUCTS.CATEGORY_ID }, Keys.CATEGORIES_PKEY, new TableField[] { Categories.CATEGORIES.ID }, true);
}
