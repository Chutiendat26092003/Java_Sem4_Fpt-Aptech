package org.aptech.t2109e.ultis;

public class OrderClauseBuilder {

    private StringBuilder whereClause;

    public OrderClauseBuilder() {
        super();

        this.whereClause = new StringBuilder();
    }

    public void add(String columnName, boolean desc) {
        // todo if columnName -> throw ex

        if (!isEmpty()) {
            this.whereClause.append(", ");
        }

        this.whereClause.append(columnName);

        if (desc) {
            this.whereClause.append(" DESC");
        }
    }

    public boolean isEmpty() {
        return this.whereClause.toString().isEmpty();
    }

    public String getClause() {
        return this.whereClause.toString();
    }


}
