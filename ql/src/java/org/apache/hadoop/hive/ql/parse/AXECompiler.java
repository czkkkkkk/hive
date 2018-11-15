package org.apache.hadoop.hive.ql.parse;

import com.google.gson.Gson;
import org.apache.hadoop.hive.ql.Context;
import org.apache.hadoop.hive.ql.exec.TableScanOperator;
import org.apache.hadoop.hive.ql.exec.Task;
import org.apache.hadoop.hive.ql.hooks.ReadEntity;
import org.apache.hadoop.hive.ql.hooks.WriteEntity;
import org.apache.hadoop.hive.ql.metadata.Table;
import org.apache.hadoop.hive.ql.parse.axe.AXEJobDesc;
import org.apache.hadoop.hive.ql.plan.MoveWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AXECompiler extends TaskCompiler {

    protected final Logger LOG = LoggerFactory.getLogger(AXECompiler.class);

    private Gson gson = new Gson();
    private AXEJobDesc jobDesc = new AXEJobDesc();

    /**
     * Override compile function to output the necessary info to file
     *
     * @param pCtx
     * @param rootTasks
     * @param inputs
     * @param outputs
     * @throws SemanticException
     */
    @Override
    public void compile(final ParseContext pCtx, final List<Task<? extends Serializable>> rootTasks,
                        final HashSet<ReadEntity> inputs, final HashSet<WriteEntity> outputs) throws SemanticException {
        for(Map.Entry<String, TableScanOperator> entry : pCtx.getTopOps().entrySet()) {
            jobDesc.addSrcTable(entry.getValue().getConf().getTableMetadata());
            jobDesc.addTableScanOperator(entry.getValue());
        }
        LOG.info("AXE INFO: Job Desc Json: " + gson.toJson(jobDesc));
    }
    @Override
    protected void decideExecMode(List<Task<? extends Serializable>> rootTasks, Context ctx,
                                  GlobalLimitCtx globalLimitCtx) throws SemanticException {
    }

    @Override
    protected void optimizeTaskPlan(List<Task<? extends Serializable>> rootTasks,
                                             ParseContext pCtx, Context ctx) throws SemanticException {

    }

    @Override
    protected void setInputFormat(Task<? extends Serializable> rootTask) {

    }

    @Override
    protected void generateTaskTree(List<Task<? extends Serializable>> rootTasks, ParseContext pCtx,
                                    List<Task<MoveWork>> mvTask, Set<ReadEntity> inputs, Set<WriteEntity> outputs) throws SemanticException {

    }
}
