package org.apache.hadoop.hive.ql.parse.axe;

import org.apache.hadoop.hive.ql.exec.TableScanOperator;
import org.apache.hadoop.hive.ql.metadata.Table;

import java.util.ArrayList;
import java.util.List;

public class AXEJobDesc {
    private List<AXETable> srcTables;
    private List<AXETableScanOperator> tableScanOperators;

    public AXEJobDesc() {
        srcTables = new ArrayList<>();
        tableScanOperators = new ArrayList<>();
    }

    public void addSrcTable(Table table) {
        srcTables.add(new AXETable(table.getTableName()));
    }
    public void addTableScanOperator(TableScanOperator op) {
        tableScanOperators.add(new AXETableScanOperator(op));
    }
}
