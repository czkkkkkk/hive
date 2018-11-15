package org.apache.hadoop.hive.ql.parse.axe;

import org.apache.hadoop.hive.ql.exec.TableScanOperator;

import java.util.List;

public class AXETableScanOperator {
    private String tableName;
    private List<Integer> needColIds;

    public AXETableScanOperator(TableScanOperator op) {
        tableName = op.getConf().getTableMetadata().getTableName();
        needColIds = op.getConf().getNeededColumnIDs();
    }
}
