package com.fudian.szhjg.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TTaskJuanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTaskJuanExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPcIdIsNull() {
            addCriterion("pc_id is null");
            return (Criteria) this;
        }

        public Criteria andPcIdIsNotNull() {
            addCriterion("pc_id is not null");
            return (Criteria) this;
        }

        public Criteria andPcIdEqualTo(String value) {
            addCriterion("pc_id =", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdNotEqualTo(String value) {
            addCriterion("pc_id <>", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdGreaterThan(String value) {
            addCriterion("pc_id >", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdGreaterThanOrEqualTo(String value) {
            addCriterion("pc_id >=", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdLessThan(String value) {
            addCriterion("pc_id <", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdLessThanOrEqualTo(String value) {
            addCriterion("pc_id <=", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdLike(String value) {
            addCriterion("pc_id like", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdNotLike(String value) {
            addCriterion("pc_id not like", value, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdIn(List<String> values) {
            addCriterion("pc_id in", values, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdNotIn(List<String> values) {
            addCriterion("pc_id not in", values, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdBetween(String value1, String value2) {
            addCriterion("pc_id between", value1, value2, "pcId");
            return (Criteria) this;
        }

        public Criteria andPcIdNotBetween(String value1, String value2) {
            addCriterion("pc_id not between", value1, value2, "pcId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andDalxIsNull() {
            addCriterion("dalx is null");
            return (Criteria) this;
        }

        public Criteria andDalxIsNotNull() {
            addCriterion("dalx is not null");
            return (Criteria) this;
        }

        public Criteria andDalxEqualTo(String value) {
            addCriterion("dalx =", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxNotEqualTo(String value) {
            addCriterion("dalx <>", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxGreaterThan(String value) {
            addCriterion("dalx >", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxGreaterThanOrEqualTo(String value) {
            addCriterion("dalx >=", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxLessThan(String value) {
            addCriterion("dalx <", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxLessThanOrEqualTo(String value) {
            addCriterion("dalx <=", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxLike(String value) {
            addCriterion("dalx like", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxNotLike(String value) {
            addCriterion("dalx not like", value, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxIn(List<String> values) {
            addCriterion("dalx in", values, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxNotIn(List<String> values) {
            addCriterion("dalx not in", values, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxBetween(String value1, String value2) {
            addCriterion("dalx between", value1, value2, "dalx");
            return (Criteria) this;
        }

        public Criteria andDalxNotBetween(String value1, String value2) {
            addCriterion("dalx not between", value1, value2, "dalx");
            return (Criteria) this;
        }

        public Criteria andQzhIsNull() {
            addCriterion("qzh is null");
            return (Criteria) this;
        }

        public Criteria andQzhIsNotNull() {
            addCriterion("qzh is not null");
            return (Criteria) this;
        }

        public Criteria andQzhEqualTo(String value) {
            addCriterion("qzh =", value, "qzh");
            return (Criteria) this;
        }

        public Criteria andQzhNotEqualTo(String value) {
            addCriterion("qzh <>", value, "qzh");
            return (Criteria) this;
        }

        public Criteria andQzhGreaterThan(String value) {
            addCriterion("qzh >", value, "qzh");
            return (Criteria) this;
        }

        public Criteria andQzhGreaterThanOrEqualTo(String value) {
            addCriterion("qzh >=", value, "qzh");
            return (Criteria) this;
        }

        public Criteria andQzhLessThan(String value) {
            addCriterion("qzh <", value, "qzh");
            return (Criteria) this;
        }

        public Criteria andQzhLessThanOrEqualTo(String value) {
            addCriterion("qzh <=", value, "qzh");
            return (Criteria) this;
        }

        public Criteria andQzhLike(String value) {
            addCriterion("qzh like", value, "qzh");
            return (Criteria) this;
        }

        public Criteria andQzhNotLike(String value) {
            addCriterion("qzh not like", value, "qzh");
            return (Criteria) this;
        }

        public Criteria andQzhIn(List<String> values) {
            addCriterion("qzh in", values, "qzh");
            return (Criteria) this;
        }

        public Criteria andQzhNotIn(List<String> values) {
            addCriterion("qzh not in", values, "qzh");
            return (Criteria) this;
        }

        public Criteria andQzhBetween(String value1, String value2) {
            addCriterion("qzh between", value1, value2, "qzh");
            return (Criteria) this;
        }

        public Criteria andQzhNotBetween(String value1, String value2) {
            addCriterion("qzh not between", value1, value2, "qzh");
            return (Criteria) this;
        }

        public Criteria andMlhIsNull() {
            addCriterion("mlh is null");
            return (Criteria) this;
        }

        public Criteria andMlhIsNotNull() {
            addCriterion("mlh is not null");
            return (Criteria) this;
        }

        public Criteria andMlhEqualTo(String value) {
            addCriterion("mlh =", value, "mlh");
            return (Criteria) this;
        }

        public Criteria andMlhNotEqualTo(String value) {
            addCriterion("mlh <>", value, "mlh");
            return (Criteria) this;
        }

        public Criteria andMlhGreaterThan(String value) {
            addCriterion("mlh >", value, "mlh");
            return (Criteria) this;
        }

        public Criteria andMlhGreaterThanOrEqualTo(String value) {
            addCriterion("mlh >=", value, "mlh");
            return (Criteria) this;
        }

        public Criteria andMlhLessThan(String value) {
            addCriterion("mlh <", value, "mlh");
            return (Criteria) this;
        }

        public Criteria andMlhLessThanOrEqualTo(String value) {
            addCriterion("mlh <=", value, "mlh");
            return (Criteria) this;
        }

        public Criteria andMlhLike(String value) {
            addCriterion("mlh like", value, "mlh");
            return (Criteria) this;
        }

        public Criteria andMlhNotLike(String value) {
            addCriterion("mlh not like", value, "mlh");
            return (Criteria) this;
        }

        public Criteria andMlhIn(List<String> values) {
            addCriterion("mlh in", values, "mlh");
            return (Criteria) this;
        }

        public Criteria andMlhNotIn(List<String> values) {
            addCriterion("mlh not in", values, "mlh");
            return (Criteria) this;
        }

        public Criteria andMlhBetween(String value1, String value2) {
            addCriterion("mlh between", value1, value2, "mlh");
            return (Criteria) this;
        }

        public Criteria andMlhNotBetween(String value1, String value2) {
            addCriterion("mlh not between", value1, value2, "mlh");
            return (Criteria) this;
        }

        public Criteria andAjhIsNull() {
            addCriterion("ajh is null");
            return (Criteria) this;
        }

        public Criteria andAjhIsNotNull() {
            addCriterion("ajh is not null");
            return (Criteria) this;
        }

        public Criteria andAjhEqualTo(String value) {
            addCriterion("ajh =", value, "ajh");
            return (Criteria) this;
        }

        public Criteria andAjhNotEqualTo(String value) {
            addCriterion("ajh <>", value, "ajh");
            return (Criteria) this;
        }

        public Criteria andAjhGreaterThan(String value) {
            addCriterion("ajh >", value, "ajh");
            return (Criteria) this;
        }

        public Criteria andAjhGreaterThanOrEqualTo(String value) {
            addCriterion("ajh >=", value, "ajh");
            return (Criteria) this;
        }

        public Criteria andAjhLessThan(String value) {
            addCriterion("ajh <", value, "ajh");
            return (Criteria) this;
        }

        public Criteria andAjhLessThanOrEqualTo(String value) {
            addCriterion("ajh <=", value, "ajh");
            return (Criteria) this;
        }

        public Criteria andAjhLike(String value) {
            addCriterion("ajh like", value, "ajh");
            return (Criteria) this;
        }

        public Criteria andAjhNotLike(String value) {
            addCriterion("ajh not like", value, "ajh");
            return (Criteria) this;
        }

        public Criteria andAjhIn(List<String> values) {
            addCriterion("ajh in", values, "ajh");
            return (Criteria) this;
        }

        public Criteria andAjhNotIn(List<String> values) {
            addCriterion("ajh not in", values, "ajh");
            return (Criteria) this;
        }

        public Criteria andAjhBetween(String value1, String value2) {
            addCriterion("ajh between", value1, value2, "ajh");
            return (Criteria) this;
        }

        public Criteria andAjhNotBetween(String value1, String value2) {
            addCriterion("ajh not between", value1, value2, "ajh");
            return (Criteria) this;
        }

        public Criteria andDhIsNull() {
            addCriterion("dh is null");
            return (Criteria) this;
        }

        public Criteria andDhIsNotNull() {
            addCriterion("dh is not null");
            return (Criteria) this;
        }

        public Criteria andDhEqualTo(String value) {
            addCriterion("dh =", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotEqualTo(String value) {
            addCriterion("dh <>", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhGreaterThan(String value) {
            addCriterion("dh >", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhGreaterThanOrEqualTo(String value) {
            addCriterion("dh >=", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLessThan(String value) {
            addCriterion("dh <", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLessThanOrEqualTo(String value) {
            addCriterion("dh <=", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhLike(String value) {
            addCriterion("dh like", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotLike(String value) {
            addCriterion("dh not like", value, "dh");
            return (Criteria) this;
        }

        public Criteria andDhIn(List<String> values) {
            addCriterion("dh in", values, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotIn(List<String> values) {
            addCriterion("dh not in", values, "dh");
            return (Criteria) this;
        }

        public Criteria andDhBetween(String value1, String value2) {
            addCriterion("dh between", value1, value2, "dh");
            return (Criteria) this;
        }

        public Criteria andDhNotBetween(String value1, String value2) {
            addCriterion("dh not between", value1, value2, "dh");
            return (Criteria) this;
        }

        public Criteria andDhqjIsNull() {
            addCriterion("dhqj is null");
            return (Criteria) this;
        }

        public Criteria andDhqjIsNotNull() {
            addCriterion("dhqj is not null");
            return (Criteria) this;
        }

        public Criteria andDhqjEqualTo(String value) {
            addCriterion("dhqj =", value, "dhqj");
            return (Criteria) this;
        }

        public Criteria andDhqjNotEqualTo(String value) {
            addCriterion("dhqj <>", value, "dhqj");
            return (Criteria) this;
        }

        public Criteria andDhqjGreaterThan(String value) {
            addCriterion("dhqj >", value, "dhqj");
            return (Criteria) this;
        }

        public Criteria andDhqjGreaterThanOrEqualTo(String value) {
            addCriterion("dhqj >=", value, "dhqj");
            return (Criteria) this;
        }

        public Criteria andDhqjLessThan(String value) {
            addCriterion("dhqj <", value, "dhqj");
            return (Criteria) this;
        }

        public Criteria andDhqjLessThanOrEqualTo(String value) {
            addCriterion("dhqj <=", value, "dhqj");
            return (Criteria) this;
        }

        public Criteria andDhqjLike(String value) {
            addCriterion("dhqj like", value, "dhqj");
            return (Criteria) this;
        }

        public Criteria andDhqjNotLike(String value) {
            addCriterion("dhqj not like", value, "dhqj");
            return (Criteria) this;
        }

        public Criteria andDhqjIn(List<String> values) {
            addCriterion("dhqj in", values, "dhqj");
            return (Criteria) this;
        }

        public Criteria andDhqjNotIn(List<String> values) {
            addCriterion("dhqj not in", values, "dhqj");
            return (Criteria) this;
        }

        public Criteria andDhqjBetween(String value1, String value2) {
            addCriterion("dhqj between", value1, value2, "dhqj");
            return (Criteria) this;
        }

        public Criteria andDhqjNotBetween(String value1, String value2) {
            addCriterion("dhqj not between", value1, value2, "dhqj");
            return (Criteria) this;
        }

        public Criteria andNdIsNull() {
            addCriterion("nd is null");
            return (Criteria) this;
        }

        public Criteria andNdIsNotNull() {
            addCriterion("nd is not null");
            return (Criteria) this;
        }

        public Criteria andNdEqualTo(String value) {
            addCriterion("nd =", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotEqualTo(String value) {
            addCriterion("nd <>", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThan(String value) {
            addCriterion("nd >", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdGreaterThanOrEqualTo(String value) {
            addCriterion("nd >=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThan(String value) {
            addCriterion("nd <", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLessThanOrEqualTo(String value) {
            addCriterion("nd <=", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdLike(String value) {
            addCriterion("nd like", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotLike(String value) {
            addCriterion("nd not like", value, "nd");
            return (Criteria) this;
        }

        public Criteria andNdIn(List<String> values) {
            addCriterion("nd in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotIn(List<String> values) {
            addCriterion("nd not in", values, "nd");
            return (Criteria) this;
        }

        public Criteria andNdBetween(String value1, String value2) {
            addCriterion("nd between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andNdNotBetween(String value1, String value2) {
            addCriterion("nd not between", value1, value2, "nd");
            return (Criteria) this;
        }

        public Criteria andBgqxIsNull() {
            addCriterion("bgqx is null");
            return (Criteria) this;
        }

        public Criteria andBgqxIsNotNull() {
            addCriterion("bgqx is not null");
            return (Criteria) this;
        }

        public Criteria andBgqxEqualTo(String value) {
            addCriterion("bgqx =", value, "bgqx");
            return (Criteria) this;
        }

        public Criteria andBgqxNotEqualTo(String value) {
            addCriterion("bgqx <>", value, "bgqx");
            return (Criteria) this;
        }

        public Criteria andBgqxGreaterThan(String value) {
            addCriterion("bgqx >", value, "bgqx");
            return (Criteria) this;
        }

        public Criteria andBgqxGreaterThanOrEqualTo(String value) {
            addCriterion("bgqx >=", value, "bgqx");
            return (Criteria) this;
        }

        public Criteria andBgqxLessThan(String value) {
            addCriterion("bgqx <", value, "bgqx");
            return (Criteria) this;
        }

        public Criteria andBgqxLessThanOrEqualTo(String value) {
            addCriterion("bgqx <=", value, "bgqx");
            return (Criteria) this;
        }

        public Criteria andBgqxLike(String value) {
            addCriterion("bgqx like", value, "bgqx");
            return (Criteria) this;
        }

        public Criteria andBgqxNotLike(String value) {
            addCriterion("bgqx not like", value, "bgqx");
            return (Criteria) this;
        }

        public Criteria andBgqxIn(List<String> values) {
            addCriterion("bgqx in", values, "bgqx");
            return (Criteria) this;
        }

        public Criteria andBgqxNotIn(List<String> values) {
            addCriterion("bgqx not in", values, "bgqx");
            return (Criteria) this;
        }

        public Criteria andBgqxBetween(String value1, String value2) {
            addCriterion("bgqx between", value1, value2, "bgqx");
            return (Criteria) this;
        }

        public Criteria andBgqxNotBetween(String value1, String value2) {
            addCriterion("bgqx not between", value1, value2, "bgqx");
            return (Criteria) this;
        }

        public Criteria andOajhIsNull() {
            addCriterion("oajh is null");
            return (Criteria) this;
        }

        public Criteria andOajhIsNotNull() {
            addCriterion("oajh is not null");
            return (Criteria) this;
        }

        public Criteria andOajhEqualTo(String value) {
            addCriterion("oajh =", value, "oajh");
            return (Criteria) this;
        }

        public Criteria andOajhNotEqualTo(String value) {
            addCriterion("oajh <>", value, "oajh");
            return (Criteria) this;
        }

        public Criteria andOajhGreaterThan(String value) {
            addCriterion("oajh >", value, "oajh");
            return (Criteria) this;
        }

        public Criteria andOajhGreaterThanOrEqualTo(String value) {
            addCriterion("oajh >=", value, "oajh");
            return (Criteria) this;
        }

        public Criteria andOajhLessThan(String value) {
            addCriterion("oajh <", value, "oajh");
            return (Criteria) this;
        }

        public Criteria andOajhLessThanOrEqualTo(String value) {
            addCriterion("oajh <=", value, "oajh");
            return (Criteria) this;
        }

        public Criteria andOajhLike(String value) {
            addCriterion("oajh like", value, "oajh");
            return (Criteria) this;
        }

        public Criteria andOajhNotLike(String value) {
            addCriterion("oajh not like", value, "oajh");
            return (Criteria) this;
        }

        public Criteria andOajhIn(List<String> values) {
            addCriterion("oajh in", values, "oajh");
            return (Criteria) this;
        }

        public Criteria andOajhNotIn(List<String> values) {
            addCriterion("oajh not in", values, "oajh");
            return (Criteria) this;
        }

        public Criteria andOajhBetween(String value1, String value2) {
            addCriterion("oajh between", value1, value2, "oajh");
            return (Criteria) this;
        }

        public Criteria andOajhNotBetween(String value1, String value2) {
            addCriterion("oajh not between", value1, value2, "oajh");
            return (Criteria) this;
        }

        public Criteria andXmIsNull() {
            addCriterion("xm is null");
            return (Criteria) this;
        }

        public Criteria andXmIsNotNull() {
            addCriterion("xm is not null");
            return (Criteria) this;
        }

        public Criteria andXmEqualTo(String value) {
            addCriterion("xm =", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotEqualTo(String value) {
            addCriterion("xm <>", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThan(String value) {
            addCriterion("xm >", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThanOrEqualTo(String value) {
            addCriterion("xm >=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThan(String value) {
            addCriterion("xm <", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThanOrEqualTo(String value) {
            addCriterion("xm <=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLike(String value) {
            addCriterion("xm like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotLike(String value) {
            addCriterion("xm not like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmIn(List<String> values) {
            addCriterion("xm in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotIn(List<String> values) {
            addCriterion("xm not in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmBetween(String value1, String value2) {
            addCriterion("xm between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotBetween(String value1, String value2) {
            addCriterion("xm not between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andXbIsNull() {
            addCriterion("xb is null");
            return (Criteria) this;
        }

        public Criteria andXbIsNotNull() {
            addCriterion("xb is not null");
            return (Criteria) this;
        }

        public Criteria andXbEqualTo(String value) {
            addCriterion("xb =", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotEqualTo(String value) {
            addCriterion("xb <>", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThan(String value) {
            addCriterion("xb >", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThanOrEqualTo(String value) {
            addCriterion("xb >=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThan(String value) {
            addCriterion("xb <", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThanOrEqualTo(String value) {
            addCriterion("xb <=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLike(String value) {
            addCriterion("xb like", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotLike(String value) {
            addCriterion("xb not like", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbIn(List<String> values) {
            addCriterion("xb in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotIn(List<String> values) {
            addCriterion("xb not in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbBetween(String value1, String value2) {
            addCriterion("xb between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotBetween(String value1, String value2) {
            addCriterion("xb not between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andMzIsNull() {
            addCriterion("mz is null");
            return (Criteria) this;
        }

        public Criteria andMzIsNotNull() {
            addCriterion("mz is not null");
            return (Criteria) this;
        }

        public Criteria andMzEqualTo(String value) {
            addCriterion("mz =", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotEqualTo(String value) {
            addCriterion("mz <>", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzGreaterThan(String value) {
            addCriterion("mz >", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzGreaterThanOrEqualTo(String value) {
            addCriterion("mz >=", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzLessThan(String value) {
            addCriterion("mz <", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzLessThanOrEqualTo(String value) {
            addCriterion("mz <=", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzLike(String value) {
            addCriterion("mz like", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotLike(String value) {
            addCriterion("mz not like", value, "mz");
            return (Criteria) this;
        }

        public Criteria andMzIn(List<String> values) {
            addCriterion("mz in", values, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotIn(List<String> values) {
            addCriterion("mz not in", values, "mz");
            return (Criteria) this;
        }

        public Criteria andMzBetween(String value1, String value2) {
            addCriterion("mz between", value1, value2, "mz");
            return (Criteria) this;
        }

        public Criteria andMzNotBetween(String value1, String value2) {
            addCriterion("mz not between", value1, value2, "mz");
            return (Criteria) this;
        }

        public Criteria andCsrqIsNull() {
            addCriterion("csrq is null");
            return (Criteria) this;
        }

        public Criteria andCsrqIsNotNull() {
            addCriterion("csrq is not null");
            return (Criteria) this;
        }

        public Criteria andCsrqEqualTo(Date value) {
            addCriterion("csrq =", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotEqualTo(Date value) {
            addCriterion("csrq <>", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqGreaterThan(Date value) {
            addCriterion("csrq >", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqGreaterThanOrEqualTo(Date value) {
            addCriterion("csrq >=", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqLessThan(Date value) {
            addCriterion("csrq <", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqLessThanOrEqualTo(Date value) {
            addCriterion("csrq <=", value, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqIn(List<Date> values) {
            addCriterion("csrq in", values, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotIn(List<Date> values) {
            addCriterion("csrq not in", values, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqBetween(Date value1, Date value2) {
            addCriterion("csrq between", value1, value2, "csrq");
            return (Criteria) this;
        }

        public Criteria andCsrqNotBetween(Date value1, Date value2) {
            addCriterion("csrq not between", value1, value2, "csrq");
            return (Criteria) this;
        }

        public Criteria andZjlxIsNull() {
            addCriterion("zjlx is null");
            return (Criteria) this;
        }

        public Criteria andZjlxIsNotNull() {
            addCriterion("zjlx is not null");
            return (Criteria) this;
        }

        public Criteria andZjlxEqualTo(String value) {
            addCriterion("zjlx =", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxNotEqualTo(String value) {
            addCriterion("zjlx <>", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxGreaterThan(String value) {
            addCriterion("zjlx >", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxGreaterThanOrEqualTo(String value) {
            addCriterion("zjlx >=", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxLessThan(String value) {
            addCriterion("zjlx <", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxLessThanOrEqualTo(String value) {
            addCriterion("zjlx <=", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxLike(String value) {
            addCriterion("zjlx like", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxNotLike(String value) {
            addCriterion("zjlx not like", value, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxIn(List<String> values) {
            addCriterion("zjlx in", values, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxNotIn(List<String> values) {
            addCriterion("zjlx not in", values, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxBetween(String value1, String value2) {
            addCriterion("zjlx between", value1, value2, "zjlx");
            return (Criteria) this;
        }

        public Criteria andZjlxNotBetween(String value1, String value2) {
            addCriterion("zjlx not between", value1, value2, "zjlx");
            return (Criteria) this;
        }

        public Criteria andCjzzsjIsNull() {
            addCriterion("cjzzsj is null");
            return (Criteria) this;
        }

        public Criteria andCjzzsjIsNotNull() {
            addCriterion("cjzzsj is not null");
            return (Criteria) this;
        }

        public Criteria andCjzzsjEqualTo(Date value) {
            addCriterion("cjzzsj =", value, "cjzzsj");
            return (Criteria) this;
        }

        public Criteria andCjzzsjNotEqualTo(Date value) {
            addCriterion("cjzzsj <>", value, "cjzzsj");
            return (Criteria) this;
        }

        public Criteria andCjzzsjGreaterThan(Date value) {
            addCriterion("cjzzsj >", value, "cjzzsj");
            return (Criteria) this;
        }

        public Criteria andCjzzsjGreaterThanOrEqualTo(Date value) {
            addCriterion("cjzzsj >=", value, "cjzzsj");
            return (Criteria) this;
        }

        public Criteria andCjzzsjLessThan(Date value) {
            addCriterion("cjzzsj <", value, "cjzzsj");
            return (Criteria) this;
        }

        public Criteria andCjzzsjLessThanOrEqualTo(Date value) {
            addCriterion("cjzzsj <=", value, "cjzzsj");
            return (Criteria) this;
        }

        public Criteria andCjzzsjIn(List<Date> values) {
            addCriterion("cjzzsj in", values, "cjzzsj");
            return (Criteria) this;
        }

        public Criteria andCjzzsjNotIn(List<Date> values) {
            addCriterion("cjzzsj not in", values, "cjzzsj");
            return (Criteria) this;
        }

        public Criteria andCjzzsjBetween(Date value1, Date value2) {
            addCriterion("cjzzsj between", value1, value2, "cjzzsj");
            return (Criteria) this;
        }

        public Criteria andCjzzsjNotBetween(Date value1, Date value2) {
            addCriterion("cjzzsj not between", value1, value2, "cjzzsj");
            return (Criteria) this;
        }

        public Criteria andCjgzsjIsNull() {
            addCriterion("cjgzsj is null");
            return (Criteria) this;
        }

        public Criteria andCjgzsjIsNotNull() {
            addCriterion("cjgzsj is not null");
            return (Criteria) this;
        }

        public Criteria andCjgzsjEqualTo(Date value) {
            addCriterion("cjgzsj =", value, "cjgzsj");
            return (Criteria) this;
        }

        public Criteria andCjgzsjNotEqualTo(Date value) {
            addCriterion("cjgzsj <>", value, "cjgzsj");
            return (Criteria) this;
        }

        public Criteria andCjgzsjGreaterThan(Date value) {
            addCriterion("cjgzsj >", value, "cjgzsj");
            return (Criteria) this;
        }

        public Criteria andCjgzsjGreaterThanOrEqualTo(Date value) {
            addCriterion("cjgzsj >=", value, "cjgzsj");
            return (Criteria) this;
        }

        public Criteria andCjgzsjLessThan(Date value) {
            addCriterion("cjgzsj <", value, "cjgzsj");
            return (Criteria) this;
        }

        public Criteria andCjgzsjLessThanOrEqualTo(Date value) {
            addCriterion("cjgzsj <=", value, "cjgzsj");
            return (Criteria) this;
        }

        public Criteria andCjgzsjIn(List<Date> values) {
            addCriterion("cjgzsj in", values, "cjgzsj");
            return (Criteria) this;
        }

        public Criteria andCjgzsjNotIn(List<Date> values) {
            addCriterion("cjgzsj not in", values, "cjgzsj");
            return (Criteria) this;
        }

        public Criteria andCjgzsjBetween(Date value1, Date value2) {
            addCriterion("cjgzsj between", value1, value2, "cjgzsj");
            return (Criteria) this;
        }

        public Criteria andCjgzsjNotBetween(Date value1, Date value2) {
            addCriterion("cjgzsj not between", value1, value2, "cjgzsj");
            return (Criteria) this;
        }

        public Criteria andBmIsNull() {
            addCriterion("bm is null");
            return (Criteria) this;
        }

        public Criteria andBmIsNotNull() {
            addCriterion("bm is not null");
            return (Criteria) this;
        }

        public Criteria andBmEqualTo(String value) {
            addCriterion("bm =", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotEqualTo(String value) {
            addCriterion("bm <>", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmGreaterThan(String value) {
            addCriterion("bm >", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmGreaterThanOrEqualTo(String value) {
            addCriterion("bm >=", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLessThan(String value) {
            addCriterion("bm <", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLessThanOrEqualTo(String value) {
            addCriterion("bm <=", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmLike(String value) {
            addCriterion("bm like", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotLike(String value) {
            addCriterion("bm not like", value, "bm");
            return (Criteria) this;
        }

        public Criteria andBmIn(List<String> values) {
            addCriterion("bm in", values, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotIn(List<String> values) {
            addCriterion("bm not in", values, "bm");
            return (Criteria) this;
        }

        public Criteria andBmBetween(String value1, String value2) {
            addCriterion("bm between", value1, value2, "bm");
            return (Criteria) this;
        }

        public Criteria andBmNotBetween(String value1, String value2) {
            addCriterion("bm not between", value1, value2, "bm");
            return (Criteria) this;
        }

        public Criteria andGbztIsNull() {
            addCriterion("gbzt is null");
            return (Criteria) this;
        }

        public Criteria andGbztIsNotNull() {
            addCriterion("gbzt is not null");
            return (Criteria) this;
        }

        public Criteria andGbztEqualTo(String value) {
            addCriterion("gbzt =", value, "gbzt");
            return (Criteria) this;
        }

        public Criteria andGbztNotEqualTo(String value) {
            addCriterion("gbzt <>", value, "gbzt");
            return (Criteria) this;
        }

        public Criteria andGbztGreaterThan(String value) {
            addCriterion("gbzt >", value, "gbzt");
            return (Criteria) this;
        }

        public Criteria andGbztGreaterThanOrEqualTo(String value) {
            addCriterion("gbzt >=", value, "gbzt");
            return (Criteria) this;
        }

        public Criteria andGbztLessThan(String value) {
            addCriterion("gbzt <", value, "gbzt");
            return (Criteria) this;
        }

        public Criteria andGbztLessThanOrEqualTo(String value) {
            addCriterion("gbzt <=", value, "gbzt");
            return (Criteria) this;
        }

        public Criteria andGbztLike(String value) {
            addCriterion("gbzt like", value, "gbzt");
            return (Criteria) this;
        }

        public Criteria andGbztNotLike(String value) {
            addCriterion("gbzt not like", value, "gbzt");
            return (Criteria) this;
        }

        public Criteria andGbztIn(List<String> values) {
            addCriterion("gbzt in", values, "gbzt");
            return (Criteria) this;
        }

        public Criteria andGbztNotIn(List<String> values) {
            addCriterion("gbzt not in", values, "gbzt");
            return (Criteria) this;
        }

        public Criteria andGbztBetween(String value1, String value2) {
            addCriterion("gbzt between", value1, value2, "gbzt");
            return (Criteria) this;
        }

        public Criteria andGbztNotBetween(String value1, String value2) {
            addCriterion("gbzt not between", value1, value2, "gbzt");
            return (Criteria) this;
        }

        public Criteria andRwztIsNull() {
            addCriterion("rwzt is null");
            return (Criteria) this;
        }

        public Criteria andRwztIsNotNull() {
            addCriterion("rwzt is not null");
            return (Criteria) this;
        }

        public Criteria andRwztEqualTo(String value) {
            addCriterion("rwzt =", value, "rwzt");
            return (Criteria) this;
        }

        public Criteria andRwztNotEqualTo(String value) {
            addCriterion("rwzt <>", value, "rwzt");
            return (Criteria) this;
        }

        public Criteria andRwztGreaterThan(String value) {
            addCriterion("rwzt >", value, "rwzt");
            return (Criteria) this;
        }

        public Criteria andRwztGreaterThanOrEqualTo(String value) {
            addCriterion("rwzt >=", value, "rwzt");
            return (Criteria) this;
        }

        public Criteria andRwztLessThan(String value) {
            addCriterion("rwzt <", value, "rwzt");
            return (Criteria) this;
        }

        public Criteria andRwztLessThanOrEqualTo(String value) {
            addCriterion("rwzt <=", value, "rwzt");
            return (Criteria) this;
        }

        public Criteria andRwztLike(String value) {
            addCriterion("rwzt like", value, "rwzt");
            return (Criteria) this;
        }

        public Criteria andRwztNotLike(String value) {
            addCriterion("rwzt not like", value, "rwzt");
            return (Criteria) this;
        }

        public Criteria andRwztIn(List<String> values) {
            addCriterion("rwzt in", values, "rwzt");
            return (Criteria) this;
        }

        public Criteria andRwztNotIn(List<String> values) {
            addCriterion("rwzt not in", values, "rwzt");
            return (Criteria) this;
        }

        public Criteria andRwztBetween(String value1, String value2) {
            addCriterion("rwzt between", value1, value2, "rwzt");
            return (Criteria) this;
        }

        public Criteria andRwztNotBetween(String value1, String value2) {
            addCriterion("rwzt not between", value1, value2, "rwzt");
            return (Criteria) this;
        }

        public Criteria andDqgxIsNull() {
            addCriterion("dqgx is null");
            return (Criteria) this;
        }

        public Criteria andDqgxIsNotNull() {
            addCriterion("dqgx is not null");
            return (Criteria) this;
        }

        public Criteria andDqgxEqualTo(Integer value) {
            addCriterion("dqgx =", value, "dqgx");
            return (Criteria) this;
        }

        public Criteria andDqgxNotEqualTo(Integer value) {
            addCriterion("dqgx <>", value, "dqgx");
            return (Criteria) this;
        }

        public Criteria andDqgxGreaterThan(Integer value) {
            addCriterion("dqgx >", value, "dqgx");
            return (Criteria) this;
        }

        public Criteria andDqgxGreaterThanOrEqualTo(Integer value) {
            addCriterion("dqgx >=", value, "dqgx");
            return (Criteria) this;
        }

        public Criteria andDqgxLessThan(Integer value) {
            addCriterion("dqgx <", value, "dqgx");
            return (Criteria) this;
        }

        public Criteria andDqgxLessThanOrEqualTo(Integer value) {
            addCriterion("dqgx <=", value, "dqgx");
            return (Criteria) this;
        }

        public Criteria andDqgxIn(List<Integer> values) {
            addCriterion("dqgx in", values, "dqgx");
            return (Criteria) this;
        }

        public Criteria andDqgxNotIn(List<Integer> values) {
            addCriterion("dqgx not in", values, "dqgx");
            return (Criteria) this;
        }

        public Criteria andDqgxBetween(Integer value1, Integer value2) {
            addCriterion("dqgx between", value1, value2, "dqgx");
            return (Criteria) this;
        }

        public Criteria andDqgxNotBetween(Integer value1, Integer value2) {
            addCriterion("dqgx not between", value1, value2, "dqgx");
            return (Criteria) this;
        }

        public Criteria andLqrIsNull() {
            addCriterion("lqr is null");
            return (Criteria) this;
        }

        public Criteria andLqrIsNotNull() {
            addCriterion("lqr is not null");
            return (Criteria) this;
        }

        public Criteria andLqrEqualTo(String value) {
            addCriterion("lqr =", value, "lqr");
            return (Criteria) this;
        }

        public Criteria andLqrNotEqualTo(String value) {
            addCriterion("lqr <>", value, "lqr");
            return (Criteria) this;
        }

        public Criteria andLqrGreaterThan(String value) {
            addCriterion("lqr >", value, "lqr");
            return (Criteria) this;
        }

        public Criteria andLqrGreaterThanOrEqualTo(String value) {
            addCriterion("lqr >=", value, "lqr");
            return (Criteria) this;
        }

        public Criteria andLqrLessThan(String value) {
            addCriterion("lqr <", value, "lqr");
            return (Criteria) this;
        }

        public Criteria andLqrLessThanOrEqualTo(String value) {
            addCriterion("lqr <=", value, "lqr");
            return (Criteria) this;
        }

        public Criteria andLqrLike(String value) {
            addCriterion("lqr like", value, "lqr");
            return (Criteria) this;
        }

        public Criteria andLqrNotLike(String value) {
            addCriterion("lqr not like", value, "lqr");
            return (Criteria) this;
        }

        public Criteria andLqrIn(List<String> values) {
            addCriterion("lqr in", values, "lqr");
            return (Criteria) this;
        }

        public Criteria andLqrNotIn(List<String> values) {
            addCriterion("lqr not in", values, "lqr");
            return (Criteria) this;
        }

        public Criteria andLqrBetween(String value1, String value2) {
            addCriterion("lqr between", value1, value2, "lqr");
            return (Criteria) this;
        }

        public Criteria andLqrNotBetween(String value1, String value2) {
            addCriterion("lqr not between", value1, value2, "lqr");
            return (Criteria) this;
        }

        public Criteria andQzmcIsNull() {
            addCriterion("qzmc is null");
            return (Criteria) this;
        }

        public Criteria andQzmcIsNotNull() {
            addCriterion("qzmc is not null");
            return (Criteria) this;
        }

        public Criteria andQzmcEqualTo(String value) {
            addCriterion("qzmc =", value, "qzmc");
            return (Criteria) this;
        }

        public Criteria andQzmcNotEqualTo(String value) {
            addCriterion("qzmc <>", value, "qzmc");
            return (Criteria) this;
        }

        public Criteria andQzmcGreaterThan(String value) {
            addCriterion("qzmc >", value, "qzmc");
            return (Criteria) this;
        }

        public Criteria andQzmcGreaterThanOrEqualTo(String value) {
            addCriterion("qzmc >=", value, "qzmc");
            return (Criteria) this;
        }

        public Criteria andQzmcLessThan(String value) {
            addCriterion("qzmc <", value, "qzmc");
            return (Criteria) this;
        }

        public Criteria andQzmcLessThanOrEqualTo(String value) {
            addCriterion("qzmc <=", value, "qzmc");
            return (Criteria) this;
        }

        public Criteria andQzmcLike(String value) {
            addCriterion("qzmc like", value, "qzmc");
            return (Criteria) this;
        }

        public Criteria andQzmcNotLike(String value) {
            addCriterion("qzmc not like", value, "qzmc");
            return (Criteria) this;
        }

        public Criteria andQzmcIn(List<String> values) {
            addCriterion("qzmc in", values, "qzmc");
            return (Criteria) this;
        }

        public Criteria andQzmcNotIn(List<String> values) {
            addCriterion("qzmc not in", values, "qzmc");
            return (Criteria) this;
        }

        public Criteria andQzmcBetween(String value1, String value2) {
            addCriterion("qzmc between", value1, value2, "qzmc");
            return (Criteria) this;
        }

        public Criteria andQzmcNotBetween(String value1, String value2) {
            addCriterion("qzmc not between", value1, value2, "qzmc");
            return (Criteria) this;
        }

        public Criteria andAjtmIsNull() {
            addCriterion("ajtm is null");
            return (Criteria) this;
        }

        public Criteria andAjtmIsNotNull() {
            addCriterion("ajtm is not null");
            return (Criteria) this;
        }

        public Criteria andAjtmEqualTo(String value) {
            addCriterion("ajtm =", value, "ajtm");
            return (Criteria) this;
        }

        public Criteria andAjtmNotEqualTo(String value) {
            addCriterion("ajtm <>", value, "ajtm");
            return (Criteria) this;
        }

        public Criteria andAjtmGreaterThan(String value) {
            addCriterion("ajtm >", value, "ajtm");
            return (Criteria) this;
        }

        public Criteria andAjtmGreaterThanOrEqualTo(String value) {
            addCriterion("ajtm >=", value, "ajtm");
            return (Criteria) this;
        }

        public Criteria andAjtmLessThan(String value) {
            addCriterion("ajtm <", value, "ajtm");
            return (Criteria) this;
        }

        public Criteria andAjtmLessThanOrEqualTo(String value) {
            addCriterion("ajtm <=", value, "ajtm");
            return (Criteria) this;
        }

        public Criteria andAjtmLike(String value) {
            addCriterion("ajtm like", value, "ajtm");
            return (Criteria) this;
        }

        public Criteria andAjtmNotLike(String value) {
            addCriterion("ajtm not like", value, "ajtm");
            return (Criteria) this;
        }

        public Criteria andAjtmIn(List<String> values) {
            addCriterion("ajtm in", values, "ajtm");
            return (Criteria) this;
        }

        public Criteria andAjtmNotIn(List<String> values) {
            addCriterion("ajtm not in", values, "ajtm");
            return (Criteria) this;
        }

        public Criteria andAjtmBetween(String value1, String value2) {
            addCriterion("ajtm between", value1, value2, "ajtm");
            return (Criteria) this;
        }

        public Criteria andAjtmNotBetween(String value1, String value2) {
            addCriterion("ajtm not between", value1, value2, "ajtm");
            return (Criteria) this;
        }

        public Criteria andFzIsNull() {
            addCriterion("fz is null");
            return (Criteria) this;
        }

        public Criteria andFzIsNotNull() {
            addCriterion("fz is not null");
            return (Criteria) this;
        }

        public Criteria andFzEqualTo(String value) {
            addCriterion("fz =", value, "fz");
            return (Criteria) this;
        }

        public Criteria andFzNotEqualTo(String value) {
            addCriterion("fz <>", value, "fz");
            return (Criteria) this;
        }

        public Criteria andFzGreaterThan(String value) {
            addCriterion("fz >", value, "fz");
            return (Criteria) this;
        }

        public Criteria andFzGreaterThanOrEqualTo(String value) {
            addCriterion("fz >=", value, "fz");
            return (Criteria) this;
        }

        public Criteria andFzLessThan(String value) {
            addCriterion("fz <", value, "fz");
            return (Criteria) this;
        }

        public Criteria andFzLessThanOrEqualTo(String value) {
            addCriterion("fz <=", value, "fz");
            return (Criteria) this;
        }

        public Criteria andFzLike(String value) {
            addCriterion("fz like", value, "fz");
            return (Criteria) this;
        }

        public Criteria andFzNotLike(String value) {
            addCriterion("fz not like", value, "fz");
            return (Criteria) this;
        }

        public Criteria andFzIn(List<String> values) {
            addCriterion("fz in", values, "fz");
            return (Criteria) this;
        }

        public Criteria andFzNotIn(List<String> values) {
            addCriterion("fz not in", values, "fz");
            return (Criteria) this;
        }

        public Criteria andFzBetween(String value1, String value2) {
            addCriterion("fz between", value1, value2, "fz");
            return (Criteria) this;
        }

        public Criteria andFzNotBetween(String value1, String value2) {
            addCriterion("fz not between", value1, value2, "fz");
            return (Criteria) this;
        }

        public Criteria andBkbsmIsNull() {
            addCriterion("bkbsm is null");
            return (Criteria) this;
        }

        public Criteria andBkbsmIsNotNull() {
            addCriterion("bkbsm is not null");
            return (Criteria) this;
        }

        public Criteria andBkbsmEqualTo(String value) {
            addCriterion("bkbsm =", value, "bkbsm");
            return (Criteria) this;
        }

        public Criteria andBkbsmNotEqualTo(String value) {
            addCriterion("bkbsm <>", value, "bkbsm");
            return (Criteria) this;
        }

        public Criteria andBkbsmGreaterThan(String value) {
            addCriterion("bkbsm >", value, "bkbsm");
            return (Criteria) this;
        }

        public Criteria andBkbsmGreaterThanOrEqualTo(String value) {
            addCriterion("bkbsm >=", value, "bkbsm");
            return (Criteria) this;
        }

        public Criteria andBkbsmLessThan(String value) {
            addCriterion("bkbsm <", value, "bkbsm");
            return (Criteria) this;
        }

        public Criteria andBkbsmLessThanOrEqualTo(String value) {
            addCriterion("bkbsm <=", value, "bkbsm");
            return (Criteria) this;
        }

        public Criteria andBkbsmLike(String value) {
            addCriterion("bkbsm like", value, "bkbsm");
            return (Criteria) this;
        }

        public Criteria andBkbsmNotLike(String value) {
            addCriterion("bkbsm not like", value, "bkbsm");
            return (Criteria) this;
        }

        public Criteria andBkbsmIn(List<String> values) {
            addCriterion("bkbsm in", values, "bkbsm");
            return (Criteria) this;
        }

        public Criteria andBkbsmNotIn(List<String> values) {
            addCriterion("bkbsm not in", values, "bkbsm");
            return (Criteria) this;
        }

        public Criteria andBkbsmBetween(String value1, String value2) {
            addCriterion("bkbsm between", value1, value2, "bkbsm");
            return (Criteria) this;
        }

        public Criteria andBkbsmNotBetween(String value1, String value2) {
            addCriterion("bkbsm not between", value1, value2, "bkbsm");
            return (Criteria) this;
        }

        public Criteria andQssjIsNull() {
            addCriterion("qssj is null");
            return (Criteria) this;
        }

        public Criteria andQssjIsNotNull() {
            addCriterion("qssj is not null");
            return (Criteria) this;
        }

        public Criteria andQssjEqualTo(String value) {
            addCriterion("qssj =", value, "qssj");
            return (Criteria) this;
        }

        public Criteria andQssjNotEqualTo(String value) {
            addCriterion("qssj <>", value, "qssj");
            return (Criteria) this;
        }

        public Criteria andQssjGreaterThan(String value) {
            addCriterion("qssj >", value, "qssj");
            return (Criteria) this;
        }

        public Criteria andQssjGreaterThanOrEqualTo(String value) {
            addCriterion("qssj >=", value, "qssj");
            return (Criteria) this;
        }

        public Criteria andQssjLessThan(String value) {
            addCriterion("qssj <", value, "qssj");
            return (Criteria) this;
        }

        public Criteria andQssjLessThanOrEqualTo(String value) {
            addCriterion("qssj <=", value, "qssj");
            return (Criteria) this;
        }

        public Criteria andQssjLike(String value) {
            addCriterion("qssj like", value, "qssj");
            return (Criteria) this;
        }

        public Criteria andQssjNotLike(String value) {
            addCriterion("qssj not like", value, "qssj");
            return (Criteria) this;
        }

        public Criteria andQssjIn(List<String> values) {
            addCriterion("qssj in", values, "qssj");
            return (Criteria) this;
        }

        public Criteria andQssjNotIn(List<String> values) {
            addCriterion("qssj not in", values, "qssj");
            return (Criteria) this;
        }

        public Criteria andQssjBetween(String value1, String value2) {
            addCriterion("qssj between", value1, value2, "qssj");
            return (Criteria) this;
        }

        public Criteria andQssjNotBetween(String value1, String value2) {
            addCriterion("qssj not between", value1, value2, "qssj");
            return (Criteria) this;
        }

        public Criteria andZzsjIsNull() {
            addCriterion("zzsj is null");
            return (Criteria) this;
        }

        public Criteria andZzsjIsNotNull() {
            addCriterion("zzsj is not null");
            return (Criteria) this;
        }

        public Criteria andZzsjEqualTo(String value) {
            addCriterion("zzsj =", value, "zzsj");
            return (Criteria) this;
        }

        public Criteria andZzsjNotEqualTo(String value) {
            addCriterion("zzsj <>", value, "zzsj");
            return (Criteria) this;
        }

        public Criteria andZzsjGreaterThan(String value) {
            addCriterion("zzsj >", value, "zzsj");
            return (Criteria) this;
        }

        public Criteria andZzsjGreaterThanOrEqualTo(String value) {
            addCriterion("zzsj >=", value, "zzsj");
            return (Criteria) this;
        }

        public Criteria andZzsjLessThan(String value) {
            addCriterion("zzsj <", value, "zzsj");
            return (Criteria) this;
        }

        public Criteria andZzsjLessThanOrEqualTo(String value) {
            addCriterion("zzsj <=", value, "zzsj");
            return (Criteria) this;
        }

        public Criteria andZzsjLike(String value) {
            addCriterion("zzsj like", value, "zzsj");
            return (Criteria) this;
        }

        public Criteria andZzsjNotLike(String value) {
            addCriterion("zzsj not like", value, "zzsj");
            return (Criteria) this;
        }

        public Criteria andZzsjIn(List<String> values) {
            addCriterion("zzsj in", values, "zzsj");
            return (Criteria) this;
        }

        public Criteria andZzsjNotIn(List<String> values) {
            addCriterion("zzsj not in", values, "zzsj");
            return (Criteria) this;
        }

        public Criteria andZzsjBetween(String value1, String value2) {
            addCriterion("zzsj between", value1, value2, "zzsj");
            return (Criteria) this;
        }

        public Criteria andZzsjNotBetween(String value1, String value2) {
            addCriterion("zzsj not between", value1, value2, "zzsj");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDagdmIsNull() {
            addCriterion("dagdm is null");
            return (Criteria) this;
        }

        public Criteria andDagdmIsNotNull() {
            addCriterion("dagdm is not null");
            return (Criteria) this;
        }

        public Criteria andDagdmEqualTo(String value) {
            addCriterion("dagdm =", value, "dagdm");
            return (Criteria) this;
        }

        public Criteria andDagdmNotEqualTo(String value) {
            addCriterion("dagdm <>", value, "dagdm");
            return (Criteria) this;
        }

        public Criteria andDagdmGreaterThan(String value) {
            addCriterion("dagdm >", value, "dagdm");
            return (Criteria) this;
        }

        public Criteria andDagdmGreaterThanOrEqualTo(String value) {
            addCriterion("dagdm >=", value, "dagdm");
            return (Criteria) this;
        }

        public Criteria andDagdmLessThan(String value) {
            addCriterion("dagdm <", value, "dagdm");
            return (Criteria) this;
        }

        public Criteria andDagdmLessThanOrEqualTo(String value) {
            addCriterion("dagdm <=", value, "dagdm");
            return (Criteria) this;
        }

        public Criteria andDagdmLike(String value) {
            addCriterion("dagdm like", value, "dagdm");
            return (Criteria) this;
        }

        public Criteria andDagdmNotLike(String value) {
            addCriterion("dagdm not like", value, "dagdm");
            return (Criteria) this;
        }

        public Criteria andDagdmIn(List<String> values) {
            addCriterion("dagdm in", values, "dagdm");
            return (Criteria) this;
        }

        public Criteria andDagdmNotIn(List<String> values) {
            addCriterion("dagdm not in", values, "dagdm");
            return (Criteria) this;
        }

        public Criteria andDagdmBetween(String value1, String value2) {
            addCriterion("dagdm between", value1, value2, "dagdm");
            return (Criteria) this;
        }

        public Criteria andDagdmNotBetween(String value1, String value2) {
            addCriterion("dagdm not between", value1, value2, "dagdm");
            return (Criteria) this;
        }

        public Criteria andDagmcIsNull() {
            addCriterion("dagmc is null");
            return (Criteria) this;
        }

        public Criteria andDagmcIsNotNull() {
            addCriterion("dagmc is not null");
            return (Criteria) this;
        }

        public Criteria andDagmcEqualTo(String value) {
            addCriterion("dagmc =", value, "dagmc");
            return (Criteria) this;
        }

        public Criteria andDagmcNotEqualTo(String value) {
            addCriterion("dagmc <>", value, "dagmc");
            return (Criteria) this;
        }

        public Criteria andDagmcGreaterThan(String value) {
            addCriterion("dagmc >", value, "dagmc");
            return (Criteria) this;
        }

        public Criteria andDagmcGreaterThanOrEqualTo(String value) {
            addCriterion("dagmc >=", value, "dagmc");
            return (Criteria) this;
        }

        public Criteria andDagmcLessThan(String value) {
            addCriterion("dagmc <", value, "dagmc");
            return (Criteria) this;
        }

        public Criteria andDagmcLessThanOrEqualTo(String value) {
            addCriterion("dagmc <=", value, "dagmc");
            return (Criteria) this;
        }

        public Criteria andDagmcLike(String value) {
            addCriterion("dagmc like", value, "dagmc");
            return (Criteria) this;
        }

        public Criteria andDagmcNotLike(String value) {
            addCriterion("dagmc not like", value, "dagmc");
            return (Criteria) this;
        }

        public Criteria andDagmcIn(List<String> values) {
            addCriterion("dagmc in", values, "dagmc");
            return (Criteria) this;
        }

        public Criteria andDagmcNotIn(List<String> values) {
            addCriterion("dagmc not in", values, "dagmc");
            return (Criteria) this;
        }

        public Criteria andDagmcBetween(String value1, String value2) {
            addCriterion("dagmc between", value1, value2, "dagmc");
            return (Criteria) this;
        }

        public Criteria andDagmcNotBetween(String value1, String value2) {
            addCriterion("dagmc not between", value1, value2, "dagmc");
            return (Criteria) this;
        }

        public Criteria andYsIsNull() {
            addCriterion("ys is null");
            return (Criteria) this;
        }

        public Criteria andYsIsNotNull() {
            addCriterion("ys is not null");
            return (Criteria) this;
        }

        public Criteria andYsEqualTo(Integer value) {
            addCriterion("ys =", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsNotEqualTo(Integer value) {
            addCriterion("ys <>", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsGreaterThan(Integer value) {
            addCriterion("ys >", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ys >=", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsLessThan(Integer value) {
            addCriterion("ys <", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsLessThanOrEqualTo(Integer value) {
            addCriterion("ys <=", value, "ys");
            return (Criteria) this;
        }

        public Criteria andYsIn(List<Integer> values) {
            addCriterion("ys in", values, "ys");
            return (Criteria) this;
        }

        public Criteria andYsNotIn(List<Integer> values) {
            addCriterion("ys not in", values, "ys");
            return (Criteria) this;
        }

        public Criteria andYsBetween(Integer value1, Integer value2) {
            addCriterion("ys between", value1, value2, "ys");
            return (Criteria) this;
        }

        public Criteria andYsNotBetween(Integer value1, Integer value2) {
            addCriterion("ys not between", value1, value2, "ys");
            return (Criteria) this;
        }

        public Criteria andClaimTimeIsNull() {
            addCriterion("claim_time is null");
            return (Criteria) this;
        }

        public Criteria andClaimTimeIsNotNull() {
            addCriterion("claim_time is not null");
            return (Criteria) this;
        }

        public Criteria andClaimTimeEqualTo(Date value) {
            addCriterion("claim_time =", value, "claimTime");
            return (Criteria) this;
        }

        public Criteria andClaimTimeNotEqualTo(Date value) {
            addCriterion("claim_time <>", value, "claimTime");
            return (Criteria) this;
        }

        public Criteria andClaimTimeGreaterThan(Date value) {
            addCriterion("claim_time >", value, "claimTime");
            return (Criteria) this;
        }

        public Criteria andClaimTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("claim_time >=", value, "claimTime");
            return (Criteria) this;
        }

        public Criteria andClaimTimeLessThan(Date value) {
            addCriterion("claim_time <", value, "claimTime");
            return (Criteria) this;
        }

        public Criteria andClaimTimeLessThanOrEqualTo(Date value) {
            addCriterion("claim_time <=", value, "claimTime");
            return (Criteria) this;
        }

        public Criteria andClaimTimeIn(List<Date> values) {
            addCriterion("claim_time in", values, "claimTime");
            return (Criteria) this;
        }

        public Criteria andClaimTimeNotIn(List<Date> values) {
            addCriterion("claim_time not in", values, "claimTime");
            return (Criteria) this;
        }

        public Criteria andClaimTimeBetween(Date value1, Date value2) {
            addCriterion("claim_time between", value1, value2, "claimTime");
            return (Criteria) this;
        }

        public Criteria andClaimTimeNotBetween(Date value1, Date value2) {
            addCriterion("claim_time not between", value1, value2, "claimTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}