package org.aptech.t2109e.ultis;

import org.aptech.t2109e.contant.SqlStat;

public class WhereClauseBuilder {
    private  StringBuilder whereClause;

    public void  andClause(String clause) {
        //todo: thêm vào đoạn and name = ''..
        if(!isEmpty()) {
            this.whereClause.append(SqlStat.SPACE).append(SqlStat.AND).append(SqlStat.SPACE);
        }
        this.whereClause.append(clause);
    }

    public void  orClause(String clause) {
        //todo: thêm vào đoạn and name = ''..
        if(!isEmpty()) {
            this.whereClause.append(SqlStat.SPACE).append(SqlStat.OR).append(SqlStat.SPACE);
        }
        this.whereClause.append(clause);
    }

    public boolean isEmpty() {
        return this.whereClause.toString().isEmpty();
    }

    public String getClause() {
        return  this.whereClause.toString();
    }
}
