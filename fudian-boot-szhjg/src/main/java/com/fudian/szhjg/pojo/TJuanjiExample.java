package com.fudian.szhjg.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TJuanjiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TJuanjiExample() {
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

        public Criteria andCatalogedIsNull() {
            addCriterion("cataloged is null");
            return (Criteria) this;
        }

        public Criteria andCatalogedIsNotNull() {
            addCriterion("cataloged is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogedEqualTo(String value) {
            addCriterion("cataloged =", value, "cataloged");
            return (Criteria) this;
        }

        public Criteria andCatalogedNotEqualTo(String value) {
            addCriterion("cataloged <>", value, "cataloged");
            return (Criteria) this;
        }

        public Criteria andCatalogedGreaterThan(String value) {
            addCriterion("cataloged >", value, "cataloged");
            return (Criteria) this;
        }

        public Criteria andCatalogedGreaterThanOrEqualTo(String value) {
            addCriterion("cataloged >=", value, "cataloged");
            return (Criteria) this;
        }

        public Criteria andCatalogedLessThan(String value) {
            addCriterion("cataloged <", value, "cataloged");
            return (Criteria) this;
        }

        public Criteria andCatalogedLessThanOrEqualTo(String value) {
            addCriterion("cataloged <=", value, "cataloged");
            return (Criteria) this;
        }

        public Criteria andCatalogedLike(String value) {
            addCriterion("cataloged like", value, "cataloged");
            return (Criteria) this;
        }

        public Criteria andCatalogedNotLike(String value) {
            addCriterion("cataloged not like", value, "cataloged");
            return (Criteria) this;
        }

        public Criteria andCatalogedIn(List<String> values) {
            addCriterion("cataloged in", values, "cataloged");
            return (Criteria) this;
        }

        public Criteria andCatalogedNotIn(List<String> values) {
            addCriterion("cataloged not in", values, "cataloged");
            return (Criteria) this;
        }

        public Criteria andCatalogedBetween(String value1, String value2) {
            addCriterion("cataloged between", value1, value2, "cataloged");
            return (Criteria) this;
        }

        public Criteria andCatalogedNotBetween(String value1, String value2) {
            addCriterion("cataloged not between", value1, value2, "cataloged");
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

        public Criteria andBhIsNull() {
            addCriterion("bh is null");
            return (Criteria) this;
        }

        public Criteria andBhIsNotNull() {
            addCriterion("bh is not null");
            return (Criteria) this;
        }

        public Criteria andBhEqualTo(String value) {
            addCriterion("bh =", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotEqualTo(String value) {
            addCriterion("bh <>", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhGreaterThan(String value) {
            addCriterion("bh >", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhGreaterThanOrEqualTo(String value) {
            addCriterion("bh >=", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLessThan(String value) {
            addCriterion("bh <", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLessThanOrEqualTo(String value) {
            addCriterion("bh <=", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhLike(String value) {
            addCriterion("bh like", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotLike(String value) {
            addCriterion("bh not like", value, "bh");
            return (Criteria) this;
        }

        public Criteria andBhIn(List<String> values) {
            addCriterion("bh in", values, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotIn(List<String> values) {
            addCriterion("bh not in", values, "bh");
            return (Criteria) this;
        }

        public Criteria andBhBetween(String value1, String value2) {
            addCriterion("bh between", value1, value2, "bh");
            return (Criteria) this;
        }

        public Criteria andBhNotBetween(String value1, String value2) {
            addCriterion("bh not between", value1, value2, "bh");
            return (Criteria) this;
        }

        public Criteria andField1IsNull() {
            addCriterion("field1 is null");
            return (Criteria) this;
        }

        public Criteria andField1IsNotNull() {
            addCriterion("field1 is not null");
            return (Criteria) this;
        }

        public Criteria andField1EqualTo(String value) {
            addCriterion("field1 =", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1NotEqualTo(String value) {
            addCriterion("field1 <>", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1GreaterThan(String value) {
            addCriterion("field1 >", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1GreaterThanOrEqualTo(String value) {
            addCriterion("field1 >=", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1LessThan(String value) {
            addCriterion("field1 <", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1LessThanOrEqualTo(String value) {
            addCriterion("field1 <=", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1Like(String value) {
            addCriterion("field1 like", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1NotLike(String value) {
            addCriterion("field1 not like", value, "field1");
            return (Criteria) this;
        }

        public Criteria andField1In(List<String> values) {
            addCriterion("field1 in", values, "field1");
            return (Criteria) this;
        }

        public Criteria andField1NotIn(List<String> values) {
            addCriterion("field1 not in", values, "field1");
            return (Criteria) this;
        }

        public Criteria andField1Between(String value1, String value2) {
            addCriterion("field1 between", value1, value2, "field1");
            return (Criteria) this;
        }

        public Criteria andField1NotBetween(String value1, String value2) {
            addCriterion("field1 not between", value1, value2, "field1");
            return (Criteria) this;
        }

        public Criteria andField2IsNull() {
            addCriterion("field2 is null");
            return (Criteria) this;
        }

        public Criteria andField2IsNotNull() {
            addCriterion("field2 is not null");
            return (Criteria) this;
        }

        public Criteria andField2EqualTo(String value) {
            addCriterion("field2 =", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2NotEqualTo(String value) {
            addCriterion("field2 <>", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2GreaterThan(String value) {
            addCriterion("field2 >", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2GreaterThanOrEqualTo(String value) {
            addCriterion("field2 >=", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2LessThan(String value) {
            addCriterion("field2 <", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2LessThanOrEqualTo(String value) {
            addCriterion("field2 <=", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2Like(String value) {
            addCriterion("field2 like", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2NotLike(String value) {
            addCriterion("field2 not like", value, "field2");
            return (Criteria) this;
        }

        public Criteria andField2In(List<String> values) {
            addCriterion("field2 in", values, "field2");
            return (Criteria) this;
        }

        public Criteria andField2NotIn(List<String> values) {
            addCriterion("field2 not in", values, "field2");
            return (Criteria) this;
        }

        public Criteria andField2Between(String value1, String value2) {
            addCriterion("field2 between", value1, value2, "field2");
            return (Criteria) this;
        }

        public Criteria andField2NotBetween(String value1, String value2) {
            addCriterion("field2 not between", value1, value2, "field2");
            return (Criteria) this;
        }

        public Criteria andField3IsNull() {
            addCriterion("field3 is null");
            return (Criteria) this;
        }

        public Criteria andField3IsNotNull() {
            addCriterion("field3 is not null");
            return (Criteria) this;
        }

        public Criteria andField3EqualTo(String value) {
            addCriterion("field3 =", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3NotEqualTo(String value) {
            addCriterion("field3 <>", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3GreaterThan(String value) {
            addCriterion("field3 >", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3GreaterThanOrEqualTo(String value) {
            addCriterion("field3 >=", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3LessThan(String value) {
            addCriterion("field3 <", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3LessThanOrEqualTo(String value) {
            addCriterion("field3 <=", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3Like(String value) {
            addCriterion("field3 like", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3NotLike(String value) {
            addCriterion("field3 not like", value, "field3");
            return (Criteria) this;
        }

        public Criteria andField3In(List<String> values) {
            addCriterion("field3 in", values, "field3");
            return (Criteria) this;
        }

        public Criteria andField3NotIn(List<String> values) {
            addCriterion("field3 not in", values, "field3");
            return (Criteria) this;
        }

        public Criteria andField3Between(String value1, String value2) {
            addCriterion("field3 between", value1, value2, "field3");
            return (Criteria) this;
        }

        public Criteria andField3NotBetween(String value1, String value2) {
            addCriterion("field3 not between", value1, value2, "field3");
            return (Criteria) this;
        }

        public Criteria andField4IsNull() {
            addCriterion("field4 is null");
            return (Criteria) this;
        }

        public Criteria andField4IsNotNull() {
            addCriterion("field4 is not null");
            return (Criteria) this;
        }

        public Criteria andField4EqualTo(String value) {
            addCriterion("field4 =", value, "field4");
            return (Criteria) this;
        }

        public Criteria andField4NotEqualTo(String value) {
            addCriterion("field4 <>", value, "field4");
            return (Criteria) this;
        }

        public Criteria andField4GreaterThan(String value) {
            addCriterion("field4 >", value, "field4");
            return (Criteria) this;
        }

        public Criteria andField4GreaterThanOrEqualTo(String value) {
            addCriterion("field4 >=", value, "field4");
            return (Criteria) this;
        }

        public Criteria andField4LessThan(String value) {
            addCriterion("field4 <", value, "field4");
            return (Criteria) this;
        }

        public Criteria andField4LessThanOrEqualTo(String value) {
            addCriterion("field4 <=", value, "field4");
            return (Criteria) this;
        }

        public Criteria andField4Like(String value) {
            addCriterion("field4 like", value, "field4");
            return (Criteria) this;
        }

        public Criteria andField4NotLike(String value) {
            addCriterion("field4 not like", value, "field4");
            return (Criteria) this;
        }

        public Criteria andField4In(List<String> values) {
            addCriterion("field4 in", values, "field4");
            return (Criteria) this;
        }

        public Criteria andField4NotIn(List<String> values) {
            addCriterion("field4 not in", values, "field4");
            return (Criteria) this;
        }

        public Criteria andField4Between(String value1, String value2) {
            addCriterion("field4 between", value1, value2, "field4");
            return (Criteria) this;
        }

        public Criteria andField4NotBetween(String value1, String value2) {
            addCriterion("field4 not between", value1, value2, "field4");
            return (Criteria) this;
        }

        public Criteria andField5IsNull() {
            addCriterion("field5 is null");
            return (Criteria) this;
        }

        public Criteria andField5IsNotNull() {
            addCriterion("field5 is not null");
            return (Criteria) this;
        }

        public Criteria andField5EqualTo(String value) {
            addCriterion("field5 =", value, "field5");
            return (Criteria) this;
        }

        public Criteria andField5NotEqualTo(String value) {
            addCriterion("field5 <>", value, "field5");
            return (Criteria) this;
        }

        public Criteria andField5GreaterThan(String value) {
            addCriterion("field5 >", value, "field5");
            return (Criteria) this;
        }

        public Criteria andField5GreaterThanOrEqualTo(String value) {
            addCriterion("field5 >=", value, "field5");
            return (Criteria) this;
        }

        public Criteria andField5LessThan(String value) {
            addCriterion("field5 <", value, "field5");
            return (Criteria) this;
        }

        public Criteria andField5LessThanOrEqualTo(String value) {
            addCriterion("field5 <=", value, "field5");
            return (Criteria) this;
        }

        public Criteria andField5Like(String value) {
            addCriterion("field5 like", value, "field5");
            return (Criteria) this;
        }

        public Criteria andField5NotLike(String value) {
            addCriterion("field5 not like", value, "field5");
            return (Criteria) this;
        }

        public Criteria andField5In(List<String> values) {
            addCriterion("field5 in", values, "field5");
            return (Criteria) this;
        }

        public Criteria andField5NotIn(List<String> values) {
            addCriterion("field5 not in", values, "field5");
            return (Criteria) this;
        }

        public Criteria andField5Between(String value1, String value2) {
            addCriterion("field5 between", value1, value2, "field5");
            return (Criteria) this;
        }

        public Criteria andField5NotBetween(String value1, String value2) {
            addCriterion("field5 not between", value1, value2, "field5");
            return (Criteria) this;
        }

        public Criteria andField6IsNull() {
            addCriterion("field6 is null");
            return (Criteria) this;
        }

        public Criteria andField6IsNotNull() {
            addCriterion("field6 is not null");
            return (Criteria) this;
        }

        public Criteria andField6EqualTo(String value) {
            addCriterion("field6 =", value, "field6");
            return (Criteria) this;
        }

        public Criteria andField6NotEqualTo(String value) {
            addCriterion("field6 <>", value, "field6");
            return (Criteria) this;
        }

        public Criteria andField6GreaterThan(String value) {
            addCriterion("field6 >", value, "field6");
            return (Criteria) this;
        }

        public Criteria andField6GreaterThanOrEqualTo(String value) {
            addCriterion("field6 >=", value, "field6");
            return (Criteria) this;
        }

        public Criteria andField6LessThan(String value) {
            addCriterion("field6 <", value, "field6");
            return (Criteria) this;
        }

        public Criteria andField6LessThanOrEqualTo(String value) {
            addCriterion("field6 <=", value, "field6");
            return (Criteria) this;
        }

        public Criteria andField6Like(String value) {
            addCriterion("field6 like", value, "field6");
            return (Criteria) this;
        }

        public Criteria andField6NotLike(String value) {
            addCriterion("field6 not like", value, "field6");
            return (Criteria) this;
        }

        public Criteria andField6In(List<String> values) {
            addCriterion("field6 in", values, "field6");
            return (Criteria) this;
        }

        public Criteria andField6NotIn(List<String> values) {
            addCriterion("field6 not in", values, "field6");
            return (Criteria) this;
        }

        public Criteria andField6Between(String value1, String value2) {
            addCriterion("field6 between", value1, value2, "field6");
            return (Criteria) this;
        }

        public Criteria andField6NotBetween(String value1, String value2) {
            addCriterion("field6 not between", value1, value2, "field6");
            return (Criteria) this;
        }

        public Criteria andField7IsNull() {
            addCriterion("field7 is null");
            return (Criteria) this;
        }

        public Criteria andField7IsNotNull() {
            addCriterion("field7 is not null");
            return (Criteria) this;
        }

        public Criteria andField7EqualTo(String value) {
            addCriterion("field7 =", value, "field7");
            return (Criteria) this;
        }

        public Criteria andField7NotEqualTo(String value) {
            addCriterion("field7 <>", value, "field7");
            return (Criteria) this;
        }

        public Criteria andField7GreaterThan(String value) {
            addCriterion("field7 >", value, "field7");
            return (Criteria) this;
        }

        public Criteria andField7GreaterThanOrEqualTo(String value) {
            addCriterion("field7 >=", value, "field7");
            return (Criteria) this;
        }

        public Criteria andField7LessThan(String value) {
            addCriterion("field7 <", value, "field7");
            return (Criteria) this;
        }

        public Criteria andField7LessThanOrEqualTo(String value) {
            addCriterion("field7 <=", value, "field7");
            return (Criteria) this;
        }

        public Criteria andField7Like(String value) {
            addCriterion("field7 like", value, "field7");
            return (Criteria) this;
        }

        public Criteria andField7NotLike(String value) {
            addCriterion("field7 not like", value, "field7");
            return (Criteria) this;
        }

        public Criteria andField7In(List<String> values) {
            addCriterion("field7 in", values, "field7");
            return (Criteria) this;
        }

        public Criteria andField7NotIn(List<String> values) {
            addCriterion("field7 not in", values, "field7");
            return (Criteria) this;
        }

        public Criteria andField7Between(String value1, String value2) {
            addCriterion("field7 between", value1, value2, "field7");
            return (Criteria) this;
        }

        public Criteria andField7NotBetween(String value1, String value2) {
            addCriterion("field7 not between", value1, value2, "field7");
            return (Criteria) this;
        }

        public Criteria andField8IsNull() {
            addCriterion("field8 is null");
            return (Criteria) this;
        }

        public Criteria andField8IsNotNull() {
            addCriterion("field8 is not null");
            return (Criteria) this;
        }

        public Criteria andField8EqualTo(String value) {
            addCriterion("field8 =", value, "field8");
            return (Criteria) this;
        }

        public Criteria andField8NotEqualTo(String value) {
            addCriterion("field8 <>", value, "field8");
            return (Criteria) this;
        }

        public Criteria andField8GreaterThan(String value) {
            addCriterion("field8 >", value, "field8");
            return (Criteria) this;
        }

        public Criteria andField8GreaterThanOrEqualTo(String value) {
            addCriterion("field8 >=", value, "field8");
            return (Criteria) this;
        }

        public Criteria andField8LessThan(String value) {
            addCriterion("field8 <", value, "field8");
            return (Criteria) this;
        }

        public Criteria andField8LessThanOrEqualTo(String value) {
            addCriterion("field8 <=", value, "field8");
            return (Criteria) this;
        }

        public Criteria andField8Like(String value) {
            addCriterion("field8 like", value, "field8");
            return (Criteria) this;
        }

        public Criteria andField8NotLike(String value) {
            addCriterion("field8 not like", value, "field8");
            return (Criteria) this;
        }

        public Criteria andField8In(List<String> values) {
            addCriterion("field8 in", values, "field8");
            return (Criteria) this;
        }

        public Criteria andField8NotIn(List<String> values) {
            addCriterion("field8 not in", values, "field8");
            return (Criteria) this;
        }

        public Criteria andField8Between(String value1, String value2) {
            addCriterion("field8 between", value1, value2, "field8");
            return (Criteria) this;
        }

        public Criteria andField8NotBetween(String value1, String value2) {
            addCriterion("field8 not between", value1, value2, "field8");
            return (Criteria) this;
        }

        public Criteria andField9IsNull() {
            addCriterion("field9 is null");
            return (Criteria) this;
        }

        public Criteria andField9IsNotNull() {
            addCriterion("field9 is not null");
            return (Criteria) this;
        }

        public Criteria andField9EqualTo(String value) {
            addCriterion("field9 =", value, "field9");
            return (Criteria) this;
        }

        public Criteria andField9NotEqualTo(String value) {
            addCriterion("field9 <>", value, "field9");
            return (Criteria) this;
        }

        public Criteria andField9GreaterThan(String value) {
            addCriterion("field9 >", value, "field9");
            return (Criteria) this;
        }

        public Criteria andField9GreaterThanOrEqualTo(String value) {
            addCriterion("field9 >=", value, "field9");
            return (Criteria) this;
        }

        public Criteria andField9LessThan(String value) {
            addCriterion("field9 <", value, "field9");
            return (Criteria) this;
        }

        public Criteria andField9LessThanOrEqualTo(String value) {
            addCriterion("field9 <=", value, "field9");
            return (Criteria) this;
        }

        public Criteria andField9Like(String value) {
            addCriterion("field9 like", value, "field9");
            return (Criteria) this;
        }

        public Criteria andField9NotLike(String value) {
            addCriterion("field9 not like", value, "field9");
            return (Criteria) this;
        }

        public Criteria andField9In(List<String> values) {
            addCriterion("field9 in", values, "field9");
            return (Criteria) this;
        }

        public Criteria andField9NotIn(List<String> values) {
            addCriterion("field9 not in", values, "field9");
            return (Criteria) this;
        }

        public Criteria andField9Between(String value1, String value2) {
            addCriterion("field9 between", value1, value2, "field9");
            return (Criteria) this;
        }

        public Criteria andField9NotBetween(String value1, String value2) {
            addCriterion("field9 not between", value1, value2, "field9");
            return (Criteria) this;
        }

        public Criteria andField10IsNull() {
            addCriterion("field10 is null");
            return (Criteria) this;
        }

        public Criteria andField10IsNotNull() {
            addCriterion("field10 is not null");
            return (Criteria) this;
        }

        public Criteria andField10EqualTo(String value) {
            addCriterion("field10 =", value, "field10");
            return (Criteria) this;
        }

        public Criteria andField10NotEqualTo(String value) {
            addCriterion("field10 <>", value, "field10");
            return (Criteria) this;
        }

        public Criteria andField10GreaterThan(String value) {
            addCriterion("field10 >", value, "field10");
            return (Criteria) this;
        }

        public Criteria andField10GreaterThanOrEqualTo(String value) {
            addCriterion("field10 >=", value, "field10");
            return (Criteria) this;
        }

        public Criteria andField10LessThan(String value) {
            addCriterion("field10 <", value, "field10");
            return (Criteria) this;
        }

        public Criteria andField10LessThanOrEqualTo(String value) {
            addCriterion("field10 <=", value, "field10");
            return (Criteria) this;
        }

        public Criteria andField10Like(String value) {
            addCriterion("field10 like", value, "field10");
            return (Criteria) this;
        }

        public Criteria andField10NotLike(String value) {
            addCriterion("field10 not like", value, "field10");
            return (Criteria) this;
        }

        public Criteria andField10In(List<String> values) {
            addCriterion("field10 in", values, "field10");
            return (Criteria) this;
        }

        public Criteria andField10NotIn(List<String> values) {
            addCriterion("field10 not in", values, "field10");
            return (Criteria) this;
        }

        public Criteria andField10Between(String value1, String value2) {
            addCriterion("field10 between", value1, value2, "field10");
            return (Criteria) this;
        }

        public Criteria andField10NotBetween(String value1, String value2) {
            addCriterion("field10 not between", value1, value2, "field10");
            return (Criteria) this;
        }

        public Criteria andField11IsNull() {
            addCriterion("field11 is null");
            return (Criteria) this;
        }

        public Criteria andField11IsNotNull() {
            addCriterion("field11 is not null");
            return (Criteria) this;
        }

        public Criteria andField11EqualTo(String value) {
            addCriterion("field11 =", value, "field11");
            return (Criteria) this;
        }

        public Criteria andField11NotEqualTo(String value) {
            addCriterion("field11 <>", value, "field11");
            return (Criteria) this;
        }

        public Criteria andField11GreaterThan(String value) {
            addCriterion("field11 >", value, "field11");
            return (Criteria) this;
        }

        public Criteria andField11GreaterThanOrEqualTo(String value) {
            addCriterion("field11 >=", value, "field11");
            return (Criteria) this;
        }

        public Criteria andField11LessThan(String value) {
            addCriterion("field11 <", value, "field11");
            return (Criteria) this;
        }

        public Criteria andField11LessThanOrEqualTo(String value) {
            addCriterion("field11 <=", value, "field11");
            return (Criteria) this;
        }

        public Criteria andField11Like(String value) {
            addCriterion("field11 like", value, "field11");
            return (Criteria) this;
        }

        public Criteria andField11NotLike(String value) {
            addCriterion("field11 not like", value, "field11");
            return (Criteria) this;
        }

        public Criteria andField11In(List<String> values) {
            addCriterion("field11 in", values, "field11");
            return (Criteria) this;
        }

        public Criteria andField11NotIn(List<String> values) {
            addCriterion("field11 not in", values, "field11");
            return (Criteria) this;
        }

        public Criteria andField11Between(String value1, String value2) {
            addCriterion("field11 between", value1, value2, "field11");
            return (Criteria) this;
        }

        public Criteria andField11NotBetween(String value1, String value2) {
            addCriterion("field11 not between", value1, value2, "field11");
            return (Criteria) this;
        }

        public Criteria andField12IsNull() {
            addCriterion("field12 is null");
            return (Criteria) this;
        }

        public Criteria andField12IsNotNull() {
            addCriterion("field12 is not null");
            return (Criteria) this;
        }

        public Criteria andField12EqualTo(String value) {
            addCriterion("field12 =", value, "field12");
            return (Criteria) this;
        }

        public Criteria andField12NotEqualTo(String value) {
            addCriterion("field12 <>", value, "field12");
            return (Criteria) this;
        }

        public Criteria andField12GreaterThan(String value) {
            addCriterion("field12 >", value, "field12");
            return (Criteria) this;
        }

        public Criteria andField12GreaterThanOrEqualTo(String value) {
            addCriterion("field12 >=", value, "field12");
            return (Criteria) this;
        }

        public Criteria andField12LessThan(String value) {
            addCriterion("field12 <", value, "field12");
            return (Criteria) this;
        }

        public Criteria andField12LessThanOrEqualTo(String value) {
            addCriterion("field12 <=", value, "field12");
            return (Criteria) this;
        }

        public Criteria andField12Like(String value) {
            addCriterion("field12 like", value, "field12");
            return (Criteria) this;
        }

        public Criteria andField12NotLike(String value) {
            addCriterion("field12 not like", value, "field12");
            return (Criteria) this;
        }

        public Criteria andField12In(List<String> values) {
            addCriterion("field12 in", values, "field12");
            return (Criteria) this;
        }

        public Criteria andField12NotIn(List<String> values) {
            addCriterion("field12 not in", values, "field12");
            return (Criteria) this;
        }

        public Criteria andField12Between(String value1, String value2) {
            addCriterion("field12 between", value1, value2, "field12");
            return (Criteria) this;
        }

        public Criteria andField12NotBetween(String value1, String value2) {
            addCriterion("field12 not between", value1, value2, "field12");
            return (Criteria) this;
        }

        public Criteria andField13IsNull() {
            addCriterion("field13 is null");
            return (Criteria) this;
        }

        public Criteria andField13IsNotNull() {
            addCriterion("field13 is not null");
            return (Criteria) this;
        }

        public Criteria andField13EqualTo(String value) {
            addCriterion("field13 =", value, "field13");
            return (Criteria) this;
        }

        public Criteria andField13NotEqualTo(String value) {
            addCriterion("field13 <>", value, "field13");
            return (Criteria) this;
        }

        public Criteria andField13GreaterThan(String value) {
            addCriterion("field13 >", value, "field13");
            return (Criteria) this;
        }

        public Criteria andField13GreaterThanOrEqualTo(String value) {
            addCriterion("field13 >=", value, "field13");
            return (Criteria) this;
        }

        public Criteria andField13LessThan(String value) {
            addCriterion("field13 <", value, "field13");
            return (Criteria) this;
        }

        public Criteria andField13LessThanOrEqualTo(String value) {
            addCriterion("field13 <=", value, "field13");
            return (Criteria) this;
        }

        public Criteria andField13Like(String value) {
            addCriterion("field13 like", value, "field13");
            return (Criteria) this;
        }

        public Criteria andField13NotLike(String value) {
            addCriterion("field13 not like", value, "field13");
            return (Criteria) this;
        }

        public Criteria andField13In(List<String> values) {
            addCriterion("field13 in", values, "field13");
            return (Criteria) this;
        }

        public Criteria andField13NotIn(List<String> values) {
            addCriterion("field13 not in", values, "field13");
            return (Criteria) this;
        }

        public Criteria andField13Between(String value1, String value2) {
            addCriterion("field13 between", value1, value2, "field13");
            return (Criteria) this;
        }

        public Criteria andField13NotBetween(String value1, String value2) {
            addCriterion("field13 not between", value1, value2, "field13");
            return (Criteria) this;
        }

        public Criteria andField14IsNull() {
            addCriterion("field14 is null");
            return (Criteria) this;
        }

        public Criteria andField14IsNotNull() {
            addCriterion("field14 is not null");
            return (Criteria) this;
        }

        public Criteria andField14EqualTo(String value) {
            addCriterion("field14 =", value, "field14");
            return (Criteria) this;
        }

        public Criteria andField14NotEqualTo(String value) {
            addCriterion("field14 <>", value, "field14");
            return (Criteria) this;
        }

        public Criteria andField14GreaterThan(String value) {
            addCriterion("field14 >", value, "field14");
            return (Criteria) this;
        }

        public Criteria andField14GreaterThanOrEqualTo(String value) {
            addCriterion("field14 >=", value, "field14");
            return (Criteria) this;
        }

        public Criteria andField14LessThan(String value) {
            addCriterion("field14 <", value, "field14");
            return (Criteria) this;
        }

        public Criteria andField14LessThanOrEqualTo(String value) {
            addCriterion("field14 <=", value, "field14");
            return (Criteria) this;
        }

        public Criteria andField14Like(String value) {
            addCriterion("field14 like", value, "field14");
            return (Criteria) this;
        }

        public Criteria andField14NotLike(String value) {
            addCriterion("field14 not like", value, "field14");
            return (Criteria) this;
        }

        public Criteria andField14In(List<String> values) {
            addCriterion("field14 in", values, "field14");
            return (Criteria) this;
        }

        public Criteria andField14NotIn(List<String> values) {
            addCriterion("field14 not in", values, "field14");
            return (Criteria) this;
        }

        public Criteria andField14Between(String value1, String value2) {
            addCriterion("field14 between", value1, value2, "field14");
            return (Criteria) this;
        }

        public Criteria andField14NotBetween(String value1, String value2) {
            addCriterion("field14 not between", value1, value2, "field14");
            return (Criteria) this;
        }

        public Criteria andField15IsNull() {
            addCriterion("field15 is null");
            return (Criteria) this;
        }

        public Criteria andField15IsNotNull() {
            addCriterion("field15 is not null");
            return (Criteria) this;
        }

        public Criteria andField15EqualTo(String value) {
            addCriterion("field15 =", value, "field15");
            return (Criteria) this;
        }

        public Criteria andField15NotEqualTo(String value) {
            addCriterion("field15 <>", value, "field15");
            return (Criteria) this;
        }

        public Criteria andField15GreaterThan(String value) {
            addCriterion("field15 >", value, "field15");
            return (Criteria) this;
        }

        public Criteria andField15GreaterThanOrEqualTo(String value) {
            addCriterion("field15 >=", value, "field15");
            return (Criteria) this;
        }

        public Criteria andField15LessThan(String value) {
            addCriterion("field15 <", value, "field15");
            return (Criteria) this;
        }

        public Criteria andField15LessThanOrEqualTo(String value) {
            addCriterion("field15 <=", value, "field15");
            return (Criteria) this;
        }

        public Criteria andField15Like(String value) {
            addCriterion("field15 like", value, "field15");
            return (Criteria) this;
        }

        public Criteria andField15NotLike(String value) {
            addCriterion("field15 not like", value, "field15");
            return (Criteria) this;
        }

        public Criteria andField15In(List<String> values) {
            addCriterion("field15 in", values, "field15");
            return (Criteria) this;
        }

        public Criteria andField15NotIn(List<String> values) {
            addCriterion("field15 not in", values, "field15");
            return (Criteria) this;
        }

        public Criteria andField15Between(String value1, String value2) {
            addCriterion("field15 between", value1, value2, "field15");
            return (Criteria) this;
        }

        public Criteria andField15NotBetween(String value1, String value2) {
            addCriterion("field15 not between", value1, value2, "field15");
            return (Criteria) this;
        }

        public Criteria andField16IsNull() {
            addCriterion("field16 is null");
            return (Criteria) this;
        }

        public Criteria andField16IsNotNull() {
            addCriterion("field16 is not null");
            return (Criteria) this;
        }

        public Criteria andField16EqualTo(String value) {
            addCriterion("field16 =", value, "field16");
            return (Criteria) this;
        }

        public Criteria andField16NotEqualTo(String value) {
            addCriterion("field16 <>", value, "field16");
            return (Criteria) this;
        }

        public Criteria andField16GreaterThan(String value) {
            addCriterion("field16 >", value, "field16");
            return (Criteria) this;
        }

        public Criteria andField16GreaterThanOrEqualTo(String value) {
            addCriterion("field16 >=", value, "field16");
            return (Criteria) this;
        }

        public Criteria andField16LessThan(String value) {
            addCriterion("field16 <", value, "field16");
            return (Criteria) this;
        }

        public Criteria andField16LessThanOrEqualTo(String value) {
            addCriterion("field16 <=", value, "field16");
            return (Criteria) this;
        }

        public Criteria andField16Like(String value) {
            addCriterion("field16 like", value, "field16");
            return (Criteria) this;
        }

        public Criteria andField16NotLike(String value) {
            addCriterion("field16 not like", value, "field16");
            return (Criteria) this;
        }

        public Criteria andField16In(List<String> values) {
            addCriterion("field16 in", values, "field16");
            return (Criteria) this;
        }

        public Criteria andField16NotIn(List<String> values) {
            addCriterion("field16 not in", values, "field16");
            return (Criteria) this;
        }

        public Criteria andField16Between(String value1, String value2) {
            addCriterion("field16 between", value1, value2, "field16");
            return (Criteria) this;
        }

        public Criteria andField16NotBetween(String value1, String value2) {
            addCriterion("field16 not between", value1, value2, "field16");
            return (Criteria) this;
        }

        public Criteria andField17IsNull() {
            addCriterion("field17 is null");
            return (Criteria) this;
        }

        public Criteria andField17IsNotNull() {
            addCriterion("field17 is not null");
            return (Criteria) this;
        }

        public Criteria andField17EqualTo(String value) {
            addCriterion("field17 =", value, "field17");
            return (Criteria) this;
        }

        public Criteria andField17NotEqualTo(String value) {
            addCriterion("field17 <>", value, "field17");
            return (Criteria) this;
        }

        public Criteria andField17GreaterThan(String value) {
            addCriterion("field17 >", value, "field17");
            return (Criteria) this;
        }

        public Criteria andField17GreaterThanOrEqualTo(String value) {
            addCriterion("field17 >=", value, "field17");
            return (Criteria) this;
        }

        public Criteria andField17LessThan(String value) {
            addCriterion("field17 <", value, "field17");
            return (Criteria) this;
        }

        public Criteria andField17LessThanOrEqualTo(String value) {
            addCriterion("field17 <=", value, "field17");
            return (Criteria) this;
        }

        public Criteria andField17Like(String value) {
            addCriterion("field17 like", value, "field17");
            return (Criteria) this;
        }

        public Criteria andField17NotLike(String value) {
            addCriterion("field17 not like", value, "field17");
            return (Criteria) this;
        }

        public Criteria andField17In(List<String> values) {
            addCriterion("field17 in", values, "field17");
            return (Criteria) this;
        }

        public Criteria andField17NotIn(List<String> values) {
            addCriterion("field17 not in", values, "field17");
            return (Criteria) this;
        }

        public Criteria andField17Between(String value1, String value2) {
            addCriterion("field17 between", value1, value2, "field17");
            return (Criteria) this;
        }

        public Criteria andField17NotBetween(String value1, String value2) {
            addCriterion("field17 not between", value1, value2, "field17");
            return (Criteria) this;
        }

        public Criteria andField18IsNull() {
            addCriterion("field18 is null");
            return (Criteria) this;
        }

        public Criteria andField18IsNotNull() {
            addCriterion("field18 is not null");
            return (Criteria) this;
        }

        public Criteria andField18EqualTo(String value) {
            addCriterion("field18 =", value, "field18");
            return (Criteria) this;
        }

        public Criteria andField18NotEqualTo(String value) {
            addCriterion("field18 <>", value, "field18");
            return (Criteria) this;
        }

        public Criteria andField18GreaterThan(String value) {
            addCriterion("field18 >", value, "field18");
            return (Criteria) this;
        }

        public Criteria andField18GreaterThanOrEqualTo(String value) {
            addCriterion("field18 >=", value, "field18");
            return (Criteria) this;
        }

        public Criteria andField18LessThan(String value) {
            addCriterion("field18 <", value, "field18");
            return (Criteria) this;
        }

        public Criteria andField18LessThanOrEqualTo(String value) {
            addCriterion("field18 <=", value, "field18");
            return (Criteria) this;
        }

        public Criteria andField18Like(String value) {
            addCriterion("field18 like", value, "field18");
            return (Criteria) this;
        }

        public Criteria andField18NotLike(String value) {
            addCriterion("field18 not like", value, "field18");
            return (Criteria) this;
        }

        public Criteria andField18In(List<String> values) {
            addCriterion("field18 in", values, "field18");
            return (Criteria) this;
        }

        public Criteria andField18NotIn(List<String> values) {
            addCriterion("field18 not in", values, "field18");
            return (Criteria) this;
        }

        public Criteria andField18Between(String value1, String value2) {
            addCriterion("field18 between", value1, value2, "field18");
            return (Criteria) this;
        }

        public Criteria andField18NotBetween(String value1, String value2) {
            addCriterion("field18 not between", value1, value2, "field18");
            return (Criteria) this;
        }

        public Criteria andField19IsNull() {
            addCriterion("field19 is null");
            return (Criteria) this;
        }

        public Criteria andField19IsNotNull() {
            addCriterion("field19 is not null");
            return (Criteria) this;
        }

        public Criteria andField19EqualTo(String value) {
            addCriterion("field19 =", value, "field19");
            return (Criteria) this;
        }

        public Criteria andField19NotEqualTo(String value) {
            addCriterion("field19 <>", value, "field19");
            return (Criteria) this;
        }

        public Criteria andField19GreaterThan(String value) {
            addCriterion("field19 >", value, "field19");
            return (Criteria) this;
        }

        public Criteria andField19GreaterThanOrEqualTo(String value) {
            addCriterion("field19 >=", value, "field19");
            return (Criteria) this;
        }

        public Criteria andField19LessThan(String value) {
            addCriterion("field19 <", value, "field19");
            return (Criteria) this;
        }

        public Criteria andField19LessThanOrEqualTo(String value) {
            addCriterion("field19 <=", value, "field19");
            return (Criteria) this;
        }

        public Criteria andField19Like(String value) {
            addCriterion("field19 like", value, "field19");
            return (Criteria) this;
        }

        public Criteria andField19NotLike(String value) {
            addCriterion("field19 not like", value, "field19");
            return (Criteria) this;
        }

        public Criteria andField19In(List<String> values) {
            addCriterion("field19 in", values, "field19");
            return (Criteria) this;
        }

        public Criteria andField19NotIn(List<String> values) {
            addCriterion("field19 not in", values, "field19");
            return (Criteria) this;
        }

        public Criteria andField19Between(String value1, String value2) {
            addCriterion("field19 between", value1, value2, "field19");
            return (Criteria) this;
        }

        public Criteria andField19NotBetween(String value1, String value2) {
            addCriterion("field19 not between", value1, value2, "field19");
            return (Criteria) this;
        }

        public Criteria andField20IsNull() {
            addCriterion("field20 is null");
            return (Criteria) this;
        }

        public Criteria andField20IsNotNull() {
            addCriterion("field20 is not null");
            return (Criteria) this;
        }

        public Criteria andField20EqualTo(String value) {
            addCriterion("field20 =", value, "field20");
            return (Criteria) this;
        }

        public Criteria andField20NotEqualTo(String value) {
            addCriterion("field20 <>", value, "field20");
            return (Criteria) this;
        }

        public Criteria andField20GreaterThan(String value) {
            addCriterion("field20 >", value, "field20");
            return (Criteria) this;
        }

        public Criteria andField20GreaterThanOrEqualTo(String value) {
            addCriterion("field20 >=", value, "field20");
            return (Criteria) this;
        }

        public Criteria andField20LessThan(String value) {
            addCriterion("field20 <", value, "field20");
            return (Criteria) this;
        }

        public Criteria andField20LessThanOrEqualTo(String value) {
            addCriterion("field20 <=", value, "field20");
            return (Criteria) this;
        }

        public Criteria andField20Like(String value) {
            addCriterion("field20 like", value, "field20");
            return (Criteria) this;
        }

        public Criteria andField20NotLike(String value) {
            addCriterion("field20 not like", value, "field20");
            return (Criteria) this;
        }

        public Criteria andField20In(List<String> values) {
            addCriterion("field20 in", values, "field20");
            return (Criteria) this;
        }

        public Criteria andField20NotIn(List<String> values) {
            addCriterion("field20 not in", values, "field20");
            return (Criteria) this;
        }

        public Criteria andField20Between(String value1, String value2) {
            addCriterion("field20 between", value1, value2, "field20");
            return (Criteria) this;
        }

        public Criteria andField20NotBetween(String value1, String value2) {
            addCriterion("field20 not between", value1, value2, "field20");
            return (Criteria) this;
        }

        public Criteria andTime1IsNull() {
            addCriterion("time1 is null");
            return (Criteria) this;
        }

        public Criteria andTime1IsNotNull() {
            addCriterion("time1 is not null");
            return (Criteria) this;
        }

        public Criteria andTime1EqualTo(Date value) {
            addCriterion("time1 =", value, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1NotEqualTo(Date value) {
            addCriterion("time1 <>", value, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1GreaterThan(Date value) {
            addCriterion("time1 >", value, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1GreaterThanOrEqualTo(Date value) {
            addCriterion("time1 >=", value, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1LessThan(Date value) {
            addCriterion("time1 <", value, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1LessThanOrEqualTo(Date value) {
            addCriterion("time1 <=", value, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1In(List<Date> values) {
            addCriterion("time1 in", values, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1NotIn(List<Date> values) {
            addCriterion("time1 not in", values, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1Between(Date value1, Date value2) {
            addCriterion("time1 between", value1, value2, "time1");
            return (Criteria) this;
        }

        public Criteria andTime1NotBetween(Date value1, Date value2) {
            addCriterion("time1 not between", value1, value2, "time1");
            return (Criteria) this;
        }

        public Criteria andTime2IsNull() {
            addCriterion("time2 is null");
            return (Criteria) this;
        }

        public Criteria andTime2IsNotNull() {
            addCriterion("time2 is not null");
            return (Criteria) this;
        }

        public Criteria andTime2EqualTo(Date value) {
            addCriterion("time2 =", value, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2NotEqualTo(Date value) {
            addCriterion("time2 <>", value, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2GreaterThan(Date value) {
            addCriterion("time2 >", value, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2GreaterThanOrEqualTo(Date value) {
            addCriterion("time2 >=", value, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2LessThan(Date value) {
            addCriterion("time2 <", value, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2LessThanOrEqualTo(Date value) {
            addCriterion("time2 <=", value, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2In(List<Date> values) {
            addCriterion("time2 in", values, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2NotIn(List<Date> values) {
            addCriterion("time2 not in", values, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2Between(Date value1, Date value2) {
            addCriterion("time2 between", value1, value2, "time2");
            return (Criteria) this;
        }

        public Criteria andTime2NotBetween(Date value1, Date value2) {
            addCriterion("time2 not between", value1, value2, "time2");
            return (Criteria) this;
        }

        public Criteria andTime3IsNull() {
            addCriterion("time3 is null");
            return (Criteria) this;
        }

        public Criteria andTime3IsNotNull() {
            addCriterion("time3 is not null");
            return (Criteria) this;
        }

        public Criteria andTime3EqualTo(Date value) {
            addCriterion("time3 =", value, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3NotEqualTo(Date value) {
            addCriterion("time3 <>", value, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3GreaterThan(Date value) {
            addCriterion("time3 >", value, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3GreaterThanOrEqualTo(Date value) {
            addCriterion("time3 >=", value, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3LessThan(Date value) {
            addCriterion("time3 <", value, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3LessThanOrEqualTo(Date value) {
            addCriterion("time3 <=", value, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3In(List<Date> values) {
            addCriterion("time3 in", values, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3NotIn(List<Date> values) {
            addCriterion("time3 not in", values, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3Between(Date value1, Date value2) {
            addCriterion("time3 between", value1, value2, "time3");
            return (Criteria) this;
        }

        public Criteria andTime3NotBetween(Date value1, Date value2) {
            addCriterion("time3 not between", value1, value2, "time3");
            return (Criteria) this;
        }

        public Criteria andTime4IsNull() {
            addCriterion("time4 is null");
            return (Criteria) this;
        }

        public Criteria andTime4IsNotNull() {
            addCriterion("time4 is not null");
            return (Criteria) this;
        }

        public Criteria andTime4EqualTo(Date value) {
            addCriterion("time4 =", value, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4NotEqualTo(Date value) {
            addCriterion("time4 <>", value, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4GreaterThan(Date value) {
            addCriterion("time4 >", value, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4GreaterThanOrEqualTo(Date value) {
            addCriterion("time4 >=", value, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4LessThan(Date value) {
            addCriterion("time4 <", value, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4LessThanOrEqualTo(Date value) {
            addCriterion("time4 <=", value, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4In(List<Date> values) {
            addCriterion("time4 in", values, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4NotIn(List<Date> values) {
            addCriterion("time4 not in", values, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4Between(Date value1, Date value2) {
            addCriterion("time4 between", value1, value2, "time4");
            return (Criteria) this;
        }

        public Criteria andTime4NotBetween(Date value1, Date value2) {
            addCriterion("time4 not between", value1, value2, "time4");
            return (Criteria) this;
        }

        public Criteria andTime5IsNull() {
            addCriterion("time5 is null");
            return (Criteria) this;
        }

        public Criteria andTime5IsNotNull() {
            addCriterion("time5 is not null");
            return (Criteria) this;
        }

        public Criteria andTime5EqualTo(Date value) {
            addCriterion("time5 =", value, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5NotEqualTo(Date value) {
            addCriterion("time5 <>", value, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5GreaterThan(Date value) {
            addCriterion("time5 >", value, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5GreaterThanOrEqualTo(Date value) {
            addCriterion("time5 >=", value, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5LessThan(Date value) {
            addCriterion("time5 <", value, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5LessThanOrEqualTo(Date value) {
            addCriterion("time5 <=", value, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5In(List<Date> values) {
            addCriterion("time5 in", values, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5NotIn(List<Date> values) {
            addCriterion("time5 not in", values, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5Between(Date value1, Date value2) {
            addCriterion("time5 between", value1, value2, "time5");
            return (Criteria) this;
        }

        public Criteria andTime5NotBetween(Date value1, Date value2) {
            addCriterion("time5 not between", value1, value2, "time5");
            return (Criteria) this;
        }

        public Criteria andInt1IsNull() {
            addCriterion("int_1 is null");
            return (Criteria) this;
        }

        public Criteria andInt1IsNotNull() {
            addCriterion("int_1 is not null");
            return (Criteria) this;
        }

        public Criteria andInt1EqualTo(Integer value) {
            addCriterion("int_1 =", value, "int1");
            return (Criteria) this;
        }

        public Criteria andInt1NotEqualTo(Integer value) {
            addCriterion("int_1 <>", value, "int1");
            return (Criteria) this;
        }

        public Criteria andInt1GreaterThan(Integer value) {
            addCriterion("int_1 >", value, "int1");
            return (Criteria) this;
        }

        public Criteria andInt1GreaterThanOrEqualTo(Integer value) {
            addCriterion("int_1 >=", value, "int1");
            return (Criteria) this;
        }

        public Criteria andInt1LessThan(Integer value) {
            addCriterion("int_1 <", value, "int1");
            return (Criteria) this;
        }

        public Criteria andInt1LessThanOrEqualTo(Integer value) {
            addCriterion("int_1 <=", value, "int1");
            return (Criteria) this;
        }

        public Criteria andInt1In(List<Integer> values) {
            addCriterion("int_1 in", values, "int1");
            return (Criteria) this;
        }

        public Criteria andInt1NotIn(List<Integer> values) {
            addCriterion("int_1 not in", values, "int1");
            return (Criteria) this;
        }

        public Criteria andInt1Between(Integer value1, Integer value2) {
            addCriterion("int_1 between", value1, value2, "int1");
            return (Criteria) this;
        }

        public Criteria andInt1NotBetween(Integer value1, Integer value2) {
            addCriterion("int_1 not between", value1, value2, "int1");
            return (Criteria) this;
        }

        public Criteria andInt2IsNull() {
            addCriterion("int_2 is null");
            return (Criteria) this;
        }

        public Criteria andInt2IsNotNull() {
            addCriterion("int_2 is not null");
            return (Criteria) this;
        }

        public Criteria andInt2EqualTo(Integer value) {
            addCriterion("int_2 =", value, "int2");
            return (Criteria) this;
        }

        public Criteria andInt2NotEqualTo(Integer value) {
            addCriterion("int_2 <>", value, "int2");
            return (Criteria) this;
        }

        public Criteria andInt2GreaterThan(Integer value) {
            addCriterion("int_2 >", value, "int2");
            return (Criteria) this;
        }

        public Criteria andInt2GreaterThanOrEqualTo(Integer value) {
            addCriterion("int_2 >=", value, "int2");
            return (Criteria) this;
        }

        public Criteria andInt2LessThan(Integer value) {
            addCriterion("int_2 <", value, "int2");
            return (Criteria) this;
        }

        public Criteria andInt2LessThanOrEqualTo(Integer value) {
            addCriterion("int_2 <=", value, "int2");
            return (Criteria) this;
        }

        public Criteria andInt2In(List<Integer> values) {
            addCriterion("int_2 in", values, "int2");
            return (Criteria) this;
        }

        public Criteria andInt2NotIn(List<Integer> values) {
            addCriterion("int_2 not in", values, "int2");
            return (Criteria) this;
        }

        public Criteria andInt2Between(Integer value1, Integer value2) {
            addCriterion("int_2 between", value1, value2, "int2");
            return (Criteria) this;
        }

        public Criteria andInt2NotBetween(Integer value1, Integer value2) {
            addCriterion("int_2 not between", value1, value2, "int2");
            return (Criteria) this;
        }

        public Criteria andInt3IsNull() {
            addCriterion("int_3 is null");
            return (Criteria) this;
        }

        public Criteria andInt3IsNotNull() {
            addCriterion("int_3 is not null");
            return (Criteria) this;
        }

        public Criteria andInt3EqualTo(Integer value) {
            addCriterion("int_3 =", value, "int3");
            return (Criteria) this;
        }

        public Criteria andInt3NotEqualTo(Integer value) {
            addCriterion("int_3 <>", value, "int3");
            return (Criteria) this;
        }

        public Criteria andInt3GreaterThan(Integer value) {
            addCriterion("int_3 >", value, "int3");
            return (Criteria) this;
        }

        public Criteria andInt3GreaterThanOrEqualTo(Integer value) {
            addCriterion("int_3 >=", value, "int3");
            return (Criteria) this;
        }

        public Criteria andInt3LessThan(Integer value) {
            addCriterion("int_3 <", value, "int3");
            return (Criteria) this;
        }

        public Criteria andInt3LessThanOrEqualTo(Integer value) {
            addCriterion("int_3 <=", value, "int3");
            return (Criteria) this;
        }

        public Criteria andInt3In(List<Integer> values) {
            addCriterion("int_3 in", values, "int3");
            return (Criteria) this;
        }

        public Criteria andInt3NotIn(List<Integer> values) {
            addCriterion("int_3 not in", values, "int3");
            return (Criteria) this;
        }

        public Criteria andInt3Between(Integer value1, Integer value2) {
            addCriterion("int_3 between", value1, value2, "int3");
            return (Criteria) this;
        }

        public Criteria andInt3NotBetween(Integer value1, Integer value2) {
            addCriterion("int_3 not between", value1, value2, "int3");
            return (Criteria) this;
        }

        public Criteria andInt4IsNull() {
            addCriterion("int_4 is null");
            return (Criteria) this;
        }

        public Criteria andInt4IsNotNull() {
            addCriterion("int_4 is not null");
            return (Criteria) this;
        }

        public Criteria andInt4EqualTo(Integer value) {
            addCriterion("int_4 =", value, "int4");
            return (Criteria) this;
        }

        public Criteria andInt4NotEqualTo(Integer value) {
            addCriterion("int_4 <>", value, "int4");
            return (Criteria) this;
        }

        public Criteria andInt4GreaterThan(Integer value) {
            addCriterion("int_4 >", value, "int4");
            return (Criteria) this;
        }

        public Criteria andInt4GreaterThanOrEqualTo(Integer value) {
            addCriterion("int_4 >=", value, "int4");
            return (Criteria) this;
        }

        public Criteria andInt4LessThan(Integer value) {
            addCriterion("int_4 <", value, "int4");
            return (Criteria) this;
        }

        public Criteria andInt4LessThanOrEqualTo(Integer value) {
            addCriterion("int_4 <=", value, "int4");
            return (Criteria) this;
        }

        public Criteria andInt4In(List<Integer> values) {
            addCriterion("int_4 in", values, "int4");
            return (Criteria) this;
        }

        public Criteria andInt4NotIn(List<Integer> values) {
            addCriterion("int_4 not in", values, "int4");
            return (Criteria) this;
        }

        public Criteria andInt4Between(Integer value1, Integer value2) {
            addCriterion("int_4 between", value1, value2, "int4");
            return (Criteria) this;
        }

        public Criteria andInt4NotBetween(Integer value1, Integer value2) {
            addCriterion("int_4 not between", value1, value2, "int4");
            return (Criteria) this;
        }

        public Criteria andInt5IsNull() {
            addCriterion("int_5 is null");
            return (Criteria) this;
        }

        public Criteria andInt5IsNotNull() {
            addCriterion("int_5 is not null");
            return (Criteria) this;
        }

        public Criteria andInt5EqualTo(Integer value) {
            addCriterion("int_5 =", value, "int5");
            return (Criteria) this;
        }

        public Criteria andInt5NotEqualTo(Integer value) {
            addCriterion("int_5 <>", value, "int5");
            return (Criteria) this;
        }

        public Criteria andInt5GreaterThan(Integer value) {
            addCriterion("int_5 >", value, "int5");
            return (Criteria) this;
        }

        public Criteria andInt5GreaterThanOrEqualTo(Integer value) {
            addCriterion("int_5 >=", value, "int5");
            return (Criteria) this;
        }

        public Criteria andInt5LessThan(Integer value) {
            addCriterion("int_5 <", value, "int5");
            return (Criteria) this;
        }

        public Criteria andInt5LessThanOrEqualTo(Integer value) {
            addCriterion("int_5 <=", value, "int5");
            return (Criteria) this;
        }

        public Criteria andInt5In(List<Integer> values) {
            addCriterion("int_5 in", values, "int5");
            return (Criteria) this;
        }

        public Criteria andInt5NotIn(List<Integer> values) {
            addCriterion("int_5 not in", values, "int5");
            return (Criteria) this;
        }

        public Criteria andInt5Between(Integer value1, Integer value2) {
            addCriterion("int_5 between", value1, value2, "int5");
            return (Criteria) this;
        }

        public Criteria andInt5NotBetween(Integer value1, Integer value2) {
            addCriterion("int_5 not between", value1, value2, "int5");
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