package com.fudian.szhjg.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMapperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMapperExample() {
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

        public Criteria andDaIdIsNull() {
            addCriterion("da_id is null");
            return (Criteria) this;
        }

        public Criteria andDaIdIsNotNull() {
            addCriterion("da_id is not null");
            return (Criteria) this;
        }

        public Criteria andDaIdEqualTo(String value) {
            addCriterion("da_id =", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotEqualTo(String value) {
            addCriterion("da_id <>", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdGreaterThan(String value) {
            addCriterion("da_id >", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdGreaterThanOrEqualTo(String value) {
            addCriterion("da_id >=", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdLessThan(String value) {
            addCriterion("da_id <", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdLessThanOrEqualTo(String value) {
            addCriterion("da_id <=", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdLike(String value) {
            addCriterion("da_id like", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotLike(String value) {
            addCriterion("da_id not like", value, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdIn(List<String> values) {
            addCriterion("da_id in", values, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotIn(List<String> values) {
            addCriterion("da_id not in", values, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdBetween(String value1, String value2) {
            addCriterion("da_id between", value1, value2, "daId");
            return (Criteria) this;
        }

        public Criteria andDaIdNotBetween(String value1, String value2) {
            addCriterion("da_id not between", value1, value2, "daId");
            return (Criteria) this;
        }

        public Criteria andPointsIsNull() {
            addCriterion("points is null");
            return (Criteria) this;
        }

        public Criteria andPointsIsNotNull() {
            addCriterion("points is not null");
            return (Criteria) this;
        }

        public Criteria andPointsEqualTo(String value) {
            addCriterion("points =", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotEqualTo(String value) {
            addCriterion("points <>", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThan(String value) {
            addCriterion("points >", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsGreaterThanOrEqualTo(String value) {
            addCriterion("points >=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThan(String value) {
            addCriterion("points <", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLessThanOrEqualTo(String value) {
            addCriterion("points <=", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsLike(String value) {
            addCriterion("points like", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotLike(String value) {
            addCriterion("points not like", value, "points");
            return (Criteria) this;
        }

        public Criteria andPointsIn(List<String> values) {
            addCriterion("points in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotIn(List<String> values) {
            addCriterion("points not in", values, "points");
            return (Criteria) this;
        }

        public Criteria andPointsBetween(String value1, String value2) {
            addCriterion("points between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andPointsNotBetween(String value1, String value2) {
            addCriterion("points not between", value1, value2, "points");
            return (Criteria) this;
        }

        public Criteria andSourceNameIsNull() {
            addCriterion("source_name is null");
            return (Criteria) this;
        }

        public Criteria andSourceNameIsNotNull() {
            addCriterion("source_name is not null");
            return (Criteria) this;
        }

        public Criteria andSourceNameEqualTo(String value) {
            addCriterion("source_name =", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotEqualTo(String value) {
            addCriterion("source_name <>", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameGreaterThan(String value) {
            addCriterion("source_name >", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("source_name >=", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLessThan(String value) {
            addCriterion("source_name <", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLessThanOrEqualTo(String value) {
            addCriterion("source_name <=", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameLike(String value) {
            addCriterion("source_name like", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotLike(String value) {
            addCriterion("source_name not like", value, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameIn(List<String> values) {
            addCriterion("source_name in", values, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotIn(List<String> values) {
            addCriterion("source_name not in", values, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameBetween(String value1, String value2) {
            addCriterion("source_name between", value1, value2, "sourceName");
            return (Criteria) this;
        }

        public Criteria andSourceNameNotBetween(String value1, String value2) {
            addCriterion("source_name not between", value1, value2, "sourceName");
            return (Criteria) this;
        }

        public Criteria andMetadataIdIsNull() {
            addCriterion("metadata_id is null");
            return (Criteria) this;
        }

        public Criteria andMetadataIdIsNotNull() {
            addCriterion("metadata_id is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataIdEqualTo(String value) {
            addCriterion("metadata_id =", value, "metadataId");
            return (Criteria) this;
        }

        public Criteria andMetadataIdNotEqualTo(String value) {
            addCriterion("metadata_id <>", value, "metadataId");
            return (Criteria) this;
        }

        public Criteria andMetadataIdGreaterThan(String value) {
            addCriterion("metadata_id >", value, "metadataId");
            return (Criteria) this;
        }

        public Criteria andMetadataIdGreaterThanOrEqualTo(String value) {
            addCriterion("metadata_id >=", value, "metadataId");
            return (Criteria) this;
        }

        public Criteria andMetadataIdLessThan(String value) {
            addCriterion("metadata_id <", value, "metadataId");
            return (Criteria) this;
        }

        public Criteria andMetadataIdLessThanOrEqualTo(String value) {
            addCriterion("metadata_id <=", value, "metadataId");
            return (Criteria) this;
        }

        public Criteria andMetadataIdLike(String value) {
            addCriterion("metadata_id like", value, "metadataId");
            return (Criteria) this;
        }

        public Criteria andMetadataIdNotLike(String value) {
            addCriterion("metadata_id not like", value, "metadataId");
            return (Criteria) this;
        }

        public Criteria andMetadataIdIn(List<String> values) {
            addCriterion("metadata_id in", values, "metadataId");
            return (Criteria) this;
        }

        public Criteria andMetadataIdNotIn(List<String> values) {
            addCriterion("metadata_id not in", values, "metadataId");
            return (Criteria) this;
        }

        public Criteria andMetadataIdBetween(String value1, String value2) {
            addCriterion("metadata_id between", value1, value2, "metadataId");
            return (Criteria) this;
        }

        public Criteria andMetadataIdNotBetween(String value1, String value2) {
            addCriterion("metadata_id not between", value1, value2, "metadataId");
            return (Criteria) this;
        }

        public Criteria andMetadataNameIsNull() {
            addCriterion("metadata_name is null");
            return (Criteria) this;
        }

        public Criteria andMetadataNameIsNotNull() {
            addCriterion("metadata_name is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataNameEqualTo(String value) {
            addCriterion("metadata_name =", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameNotEqualTo(String value) {
            addCriterion("metadata_name <>", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameGreaterThan(String value) {
            addCriterion("metadata_name >", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameGreaterThanOrEqualTo(String value) {
            addCriterion("metadata_name >=", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameLessThan(String value) {
            addCriterion("metadata_name <", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameLessThanOrEqualTo(String value) {
            addCriterion("metadata_name <=", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameLike(String value) {
            addCriterion("metadata_name like", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameNotLike(String value) {
            addCriterion("metadata_name not like", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameIn(List<String> values) {
            addCriterion("metadata_name in", values, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameNotIn(List<String> values) {
            addCriterion("metadata_name not in", values, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameBetween(String value1, String value2) {
            addCriterion("metadata_name between", value1, value2, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameNotBetween(String value1, String value2) {
            addCriterion("metadata_name not between", value1, value2, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeIsNull() {
            addCriterion("metadata_type is null");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeIsNotNull() {
            addCriterion("metadata_type is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeEqualTo(String value) {
            addCriterion("metadata_type =", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeNotEqualTo(String value) {
            addCriterion("metadata_type <>", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeGreaterThan(String value) {
            addCriterion("metadata_type >", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("metadata_type >=", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeLessThan(String value) {
            addCriterion("metadata_type <", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeLessThanOrEqualTo(String value) {
            addCriterion("metadata_type <=", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeLike(String value) {
            addCriterion("metadata_type like", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeNotLike(String value) {
            addCriterion("metadata_type not like", value, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeIn(List<String> values) {
            addCriterion("metadata_type in", values, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeNotIn(List<String> values) {
            addCriterion("metadata_type not in", values, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeBetween(String value1, String value2) {
            addCriterion("metadata_type between", value1, value2, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataTypeNotBetween(String value1, String value2) {
            addCriterion("metadata_type not between", value1, value2, "metadataType");
            return (Criteria) this;
        }

        public Criteria andMetadataModeIsNull() {
            addCriterion("metadata_mode is null");
            return (Criteria) this;
        }

        public Criteria andMetadataModeIsNotNull() {
            addCriterion("metadata_mode is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataModeEqualTo(String value) {
            addCriterion("metadata_mode =", value, "metadataMode");
            return (Criteria) this;
        }

        public Criteria andMetadataModeNotEqualTo(String value) {
            addCriterion("metadata_mode <>", value, "metadataMode");
            return (Criteria) this;
        }

        public Criteria andMetadataModeGreaterThan(String value) {
            addCriterion("metadata_mode >", value, "metadataMode");
            return (Criteria) this;
        }

        public Criteria andMetadataModeGreaterThanOrEqualTo(String value) {
            addCriterion("metadata_mode >=", value, "metadataMode");
            return (Criteria) this;
        }

        public Criteria andMetadataModeLessThan(String value) {
            addCriterion("metadata_mode <", value, "metadataMode");
            return (Criteria) this;
        }

        public Criteria andMetadataModeLessThanOrEqualTo(String value) {
            addCriterion("metadata_mode <=", value, "metadataMode");
            return (Criteria) this;
        }

        public Criteria andMetadataModeLike(String value) {
            addCriterion("metadata_mode like", value, "metadataMode");
            return (Criteria) this;
        }

        public Criteria andMetadataModeNotLike(String value) {
            addCriterion("metadata_mode not like", value, "metadataMode");
            return (Criteria) this;
        }

        public Criteria andMetadataModeIn(List<String> values) {
            addCriterion("metadata_mode in", values, "metadataMode");
            return (Criteria) this;
        }

        public Criteria andMetadataModeNotIn(List<String> values) {
            addCriterion("metadata_mode not in", values, "metadataMode");
            return (Criteria) this;
        }

        public Criteria andMetadataModeBetween(String value1, String value2) {
            addCriterion("metadata_mode between", value1, value2, "metadataMode");
            return (Criteria) this;
        }

        public Criteria andMetadataModeNotBetween(String value1, String value2) {
            addCriterion("metadata_mode not between", value1, value2, "metadataMode");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthIsNull() {
            addCriterion("metadata_length is null");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthIsNotNull() {
            addCriterion("metadata_length is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthEqualTo(String value) {
            addCriterion("metadata_length =", value, "metadataLength");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthNotEqualTo(String value) {
            addCriterion("metadata_length <>", value, "metadataLength");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthGreaterThan(String value) {
            addCriterion("metadata_length >", value, "metadataLength");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthGreaterThanOrEqualTo(String value) {
            addCriterion("metadata_length >=", value, "metadataLength");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthLessThan(String value) {
            addCriterion("metadata_length <", value, "metadataLength");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthLessThanOrEqualTo(String value) {
            addCriterion("metadata_length <=", value, "metadataLength");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthLike(String value) {
            addCriterion("metadata_length like", value, "metadataLength");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthNotLike(String value) {
            addCriterion("metadata_length not like", value, "metadataLength");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthIn(List<String> values) {
            addCriterion("metadata_length in", values, "metadataLength");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthNotIn(List<String> values) {
            addCriterion("metadata_length not in", values, "metadataLength");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthBetween(String value1, String value2) {
            addCriterion("metadata_length between", value1, value2, "metadataLength");
            return (Criteria) this;
        }

        public Criteria andMetadataLengthNotBetween(String value1, String value2) {
            addCriterion("metadata_length not between", value1, value2, "metadataLength");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularIsNull() {
            addCriterion("metadata_regular is null");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularIsNotNull() {
            addCriterion("metadata_regular is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularEqualTo(String value) {
            addCriterion("metadata_regular =", value, "metadataRegular");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularNotEqualTo(String value) {
            addCriterion("metadata_regular <>", value, "metadataRegular");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularGreaterThan(String value) {
            addCriterion("metadata_regular >", value, "metadataRegular");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularGreaterThanOrEqualTo(String value) {
            addCriterion("metadata_regular >=", value, "metadataRegular");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularLessThan(String value) {
            addCriterion("metadata_regular <", value, "metadataRegular");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularLessThanOrEqualTo(String value) {
            addCriterion("metadata_regular <=", value, "metadataRegular");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularLike(String value) {
            addCriterion("metadata_regular like", value, "metadataRegular");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularNotLike(String value) {
            addCriterion("metadata_regular not like", value, "metadataRegular");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularIn(List<String> values) {
            addCriterion("metadata_regular in", values, "metadataRegular");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularNotIn(List<String> values) {
            addCriterion("metadata_regular not in", values, "metadataRegular");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularBetween(String value1, String value2) {
            addCriterion("metadata_regular between", value1, value2, "metadataRegular");
            return (Criteria) this;
        }

        public Criteria andMetadataRegularNotBetween(String value1, String value2) {
            addCriterion("metadata_regular not between", value1, value2, "metadataRegular");
            return (Criteria) this;
        }

        public Criteria andIsNotNullIsNull() {
            addCriterion("is_not_null is null");
            return (Criteria) this;
        }

        public Criteria andIsNotNullIsNotNull() {
            addCriterion("is_not_null is not null");
            return (Criteria) this;
        }

        public Criteria andIsNotNullEqualTo(String value) {
            addCriterion("is_not_null =", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullNotEqualTo(String value) {
            addCriterion("is_not_null <>", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullGreaterThan(String value) {
            addCriterion("is_not_null >", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullGreaterThanOrEqualTo(String value) {
            addCriterion("is_not_null >=", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullLessThan(String value) {
            addCriterion("is_not_null <", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullLessThanOrEqualTo(String value) {
            addCriterion("is_not_null <=", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullLike(String value) {
            addCriterion("is_not_null like", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullNotLike(String value) {
            addCriterion("is_not_null not like", value, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullIn(List<String> values) {
            addCriterion("is_not_null in", values, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullNotIn(List<String> values) {
            addCriterion("is_not_null not in", values, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullBetween(String value1, String value2) {
            addCriterion("is_not_null between", value1, value2, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andIsNotNullNotBetween(String value1, String value2) {
            addCriterion("is_not_null not between", value1, value2, "isNotNull");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andDisplaySetIsNull() {
            addCriterion("display_set is null");
            return (Criteria) this;
        }

        public Criteria andDisplaySetIsNotNull() {
            addCriterion("display_set is not null");
            return (Criteria) this;
        }

        public Criteria andDisplaySetEqualTo(String value) {
            addCriterion("display_set =", value, "displaySet");
            return (Criteria) this;
        }

        public Criteria andDisplaySetNotEqualTo(String value) {
            addCriterion("display_set <>", value, "displaySet");
            return (Criteria) this;
        }

        public Criteria andDisplaySetGreaterThan(String value) {
            addCriterion("display_set >", value, "displaySet");
            return (Criteria) this;
        }

        public Criteria andDisplaySetGreaterThanOrEqualTo(String value) {
            addCriterion("display_set >=", value, "displaySet");
            return (Criteria) this;
        }

        public Criteria andDisplaySetLessThan(String value) {
            addCriterion("display_set <", value, "displaySet");
            return (Criteria) this;
        }

        public Criteria andDisplaySetLessThanOrEqualTo(String value) {
            addCriterion("display_set <=", value, "displaySet");
            return (Criteria) this;
        }

        public Criteria andDisplaySetLike(String value) {
            addCriterion("display_set like", value, "displaySet");
            return (Criteria) this;
        }

        public Criteria andDisplaySetNotLike(String value) {
            addCriterion("display_set not like", value, "displaySet");
            return (Criteria) this;
        }

        public Criteria andDisplaySetIn(List<String> values) {
            addCriterion("display_set in", values, "displaySet");
            return (Criteria) this;
        }

        public Criteria andDisplaySetNotIn(List<String> values) {
            addCriterion("display_set not in", values, "displaySet");
            return (Criteria) this;
        }

        public Criteria andDisplaySetBetween(String value1, String value2) {
            addCriterion("display_set between", value1, value2, "displaySet");
            return (Criteria) this;
        }

        public Criteria andDisplaySetNotBetween(String value1, String value2) {
            addCriterion("display_set not between", value1, value2, "displaySet");
            return (Criteria) this;
        }

        public Criteria andDisplaySortIsNull() {
            addCriterion("display_sort is null");
            return (Criteria) this;
        }

        public Criteria andDisplaySortIsNotNull() {
            addCriterion("display_sort is not null");
            return (Criteria) this;
        }

        public Criteria andDisplaySortEqualTo(Integer value) {
            addCriterion("display_sort =", value, "displaySort");
            return (Criteria) this;
        }

        public Criteria andDisplaySortNotEqualTo(Integer value) {
            addCriterion("display_sort <>", value, "displaySort");
            return (Criteria) this;
        }

        public Criteria andDisplaySortGreaterThan(Integer value) {
            addCriterion("display_sort >", value, "displaySort");
            return (Criteria) this;
        }

        public Criteria andDisplaySortGreaterThanOrEqualTo(Integer value) {
            addCriterion("display_sort >=", value, "displaySort");
            return (Criteria) this;
        }

        public Criteria andDisplaySortLessThan(Integer value) {
            addCriterion("display_sort <", value, "displaySort");
            return (Criteria) this;
        }

        public Criteria andDisplaySortLessThanOrEqualTo(Integer value) {
            addCriterion("display_sort <=", value, "displaySort");
            return (Criteria) this;
        }

        public Criteria andDisplaySortIn(List<Integer> values) {
            addCriterion("display_sort in", values, "displaySort");
            return (Criteria) this;
        }

        public Criteria andDisplaySortNotIn(List<Integer> values) {
            addCriterion("display_sort not in", values, "displaySort");
            return (Criteria) this;
        }

        public Criteria andDisplaySortBetween(Integer value1, Integer value2) {
            addCriterion("display_sort between", value1, value2, "displaySort");
            return (Criteria) this;
        }

        public Criteria andDisplaySortNotBetween(Integer value1, Integer value2) {
            addCriterion("display_sort not between", value1, value2, "displaySort");
            return (Criteria) this;
        }

        public Criteria andDisplayWidthIsNull() {
            addCriterion("display_width is null");
            return (Criteria) this;
        }

        public Criteria andDisplayWidthIsNotNull() {
            addCriterion("display_width is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayWidthEqualTo(Integer value) {
            addCriterion("display_width =", value, "displayWidth");
            return (Criteria) this;
        }

        public Criteria andDisplayWidthNotEqualTo(Integer value) {
            addCriterion("display_width <>", value, "displayWidth");
            return (Criteria) this;
        }

        public Criteria andDisplayWidthGreaterThan(Integer value) {
            addCriterion("display_width >", value, "displayWidth");
            return (Criteria) this;
        }

        public Criteria andDisplayWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("display_width >=", value, "displayWidth");
            return (Criteria) this;
        }

        public Criteria andDisplayWidthLessThan(Integer value) {
            addCriterion("display_width <", value, "displayWidth");
            return (Criteria) this;
        }

        public Criteria andDisplayWidthLessThanOrEqualTo(Integer value) {
            addCriterion("display_width <=", value, "displayWidth");
            return (Criteria) this;
        }

        public Criteria andDisplayWidthIn(List<Integer> values) {
            addCriterion("display_width in", values, "displayWidth");
            return (Criteria) this;
        }

        public Criteria andDisplayWidthNotIn(List<Integer> values) {
            addCriterion("display_width not in", values, "displayWidth");
            return (Criteria) this;
        }

        public Criteria andDisplayWidthBetween(Integer value1, Integer value2) {
            addCriterion("display_width between", value1, value2, "displayWidth");
            return (Criteria) this;
        }

        public Criteria andDisplayWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("display_width not between", value1, value2, "displayWidth");
            return (Criteria) this;
        }

        public Criteria andEnterSetIsNull() {
            addCriterion("enter_set is null");
            return (Criteria) this;
        }

        public Criteria andEnterSetIsNotNull() {
            addCriterion("enter_set is not null");
            return (Criteria) this;
        }

        public Criteria andEnterSetEqualTo(String value) {
            addCriterion("enter_set =", value, "enterSet");
            return (Criteria) this;
        }

        public Criteria andEnterSetNotEqualTo(String value) {
            addCriterion("enter_set <>", value, "enterSet");
            return (Criteria) this;
        }

        public Criteria andEnterSetGreaterThan(String value) {
            addCriterion("enter_set >", value, "enterSet");
            return (Criteria) this;
        }

        public Criteria andEnterSetGreaterThanOrEqualTo(String value) {
            addCriterion("enter_set >=", value, "enterSet");
            return (Criteria) this;
        }

        public Criteria andEnterSetLessThan(String value) {
            addCriterion("enter_set <", value, "enterSet");
            return (Criteria) this;
        }

        public Criteria andEnterSetLessThanOrEqualTo(String value) {
            addCriterion("enter_set <=", value, "enterSet");
            return (Criteria) this;
        }

        public Criteria andEnterSetLike(String value) {
            addCriterion("enter_set like", value, "enterSet");
            return (Criteria) this;
        }

        public Criteria andEnterSetNotLike(String value) {
            addCriterion("enter_set not like", value, "enterSet");
            return (Criteria) this;
        }

        public Criteria andEnterSetIn(List<String> values) {
            addCriterion("enter_set in", values, "enterSet");
            return (Criteria) this;
        }

        public Criteria andEnterSetNotIn(List<String> values) {
            addCriterion("enter_set not in", values, "enterSet");
            return (Criteria) this;
        }

        public Criteria andEnterSetBetween(String value1, String value2) {
            addCriterion("enter_set between", value1, value2, "enterSet");
            return (Criteria) this;
        }

        public Criteria andEnterSetNotBetween(String value1, String value2) {
            addCriterion("enter_set not between", value1, value2, "enterSet");
            return (Criteria) this;
        }

        public Criteria andEnterSortIsNull() {
            addCriterion("enter_sort is null");
            return (Criteria) this;
        }

        public Criteria andEnterSortIsNotNull() {
            addCriterion("enter_sort is not null");
            return (Criteria) this;
        }

        public Criteria andEnterSortEqualTo(Integer value) {
            addCriterion("enter_sort =", value, "enterSort");
            return (Criteria) this;
        }

        public Criteria andEnterSortNotEqualTo(Integer value) {
            addCriterion("enter_sort <>", value, "enterSort");
            return (Criteria) this;
        }

        public Criteria andEnterSortGreaterThan(Integer value) {
            addCriterion("enter_sort >", value, "enterSort");
            return (Criteria) this;
        }

        public Criteria andEnterSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("enter_sort >=", value, "enterSort");
            return (Criteria) this;
        }

        public Criteria andEnterSortLessThan(Integer value) {
            addCriterion("enter_sort <", value, "enterSort");
            return (Criteria) this;
        }

        public Criteria andEnterSortLessThanOrEqualTo(Integer value) {
            addCriterion("enter_sort <=", value, "enterSort");
            return (Criteria) this;
        }

        public Criteria andEnterSortIn(List<Integer> values) {
            addCriterion("enter_sort in", values, "enterSort");
            return (Criteria) this;
        }

        public Criteria andEnterSortNotIn(List<Integer> values) {
            addCriterion("enter_sort not in", values, "enterSort");
            return (Criteria) this;
        }

        public Criteria andEnterSortBetween(Integer value1, Integer value2) {
            addCriterion("enter_sort between", value1, value2, "enterSort");
            return (Criteria) this;
        }

        public Criteria andEnterSortNotBetween(Integer value1, Integer value2) {
            addCriterion("enter_sort not between", value1, value2, "enterSort");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetIsNull() {
            addCriterion("description_set is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetIsNotNull() {
            addCriterion("description_set is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetEqualTo(String value) {
            addCriterion("description_set =", value, "descriptionSet");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetNotEqualTo(String value) {
            addCriterion("description_set <>", value, "descriptionSet");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetGreaterThan(String value) {
            addCriterion("description_set >", value, "descriptionSet");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetGreaterThanOrEqualTo(String value) {
            addCriterion("description_set >=", value, "descriptionSet");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetLessThan(String value) {
            addCriterion("description_set <", value, "descriptionSet");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetLessThanOrEqualTo(String value) {
            addCriterion("description_set <=", value, "descriptionSet");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetLike(String value) {
            addCriterion("description_set like", value, "descriptionSet");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetNotLike(String value) {
            addCriterion("description_set not like", value, "descriptionSet");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetIn(List<String> values) {
            addCriterion("description_set in", values, "descriptionSet");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetNotIn(List<String> values) {
            addCriterion("description_set not in", values, "descriptionSet");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetBetween(String value1, String value2) {
            addCriterion("description_set between", value1, value2, "descriptionSet");
            return (Criteria) this;
        }

        public Criteria andDescriptionSetNotBetween(String value1, String value2) {
            addCriterion("description_set not between", value1, value2, "descriptionSet");
            return (Criteria) this;
        }

        public Criteria andDescriptionSortIsNull() {
            addCriterion("description_sort is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionSortIsNotNull() {
            addCriterion("description_sort is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionSortEqualTo(Integer value) {
            addCriterion("description_sort =", value, "descriptionSort");
            return (Criteria) this;
        }

        public Criteria andDescriptionSortNotEqualTo(Integer value) {
            addCriterion("description_sort <>", value, "descriptionSort");
            return (Criteria) this;
        }

        public Criteria andDescriptionSortGreaterThan(Integer value) {
            addCriterion("description_sort >", value, "descriptionSort");
            return (Criteria) this;
        }

        public Criteria andDescriptionSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("description_sort >=", value, "descriptionSort");
            return (Criteria) this;
        }

        public Criteria andDescriptionSortLessThan(Integer value) {
            addCriterion("description_sort <", value, "descriptionSort");
            return (Criteria) this;
        }

        public Criteria andDescriptionSortLessThanOrEqualTo(Integer value) {
            addCriterion("description_sort <=", value, "descriptionSort");
            return (Criteria) this;
        }

        public Criteria andDescriptionSortIn(List<Integer> values) {
            addCriterion("description_sort in", values, "descriptionSort");
            return (Criteria) this;
        }

        public Criteria andDescriptionSortNotIn(List<Integer> values) {
            addCriterion("description_sort not in", values, "descriptionSort");
            return (Criteria) this;
        }

        public Criteria andDescriptionSortBetween(Integer value1, Integer value2) {
            addCriterion("description_sort between", value1, value2, "descriptionSort");
            return (Criteria) this;
        }

        public Criteria andDescriptionSortNotBetween(Integer value1, Integer value2) {
            addCriterion("description_sort not between", value1, value2, "descriptionSort");
            return (Criteria) this;
        }

        public Criteria andBerSetIsNull() {
            addCriterion("ber_set is null");
            return (Criteria) this;
        }

        public Criteria andBerSetIsNotNull() {
            addCriterion("ber_set is not null");
            return (Criteria) this;
        }

        public Criteria andBerSetEqualTo(String value) {
            addCriterion("ber_set =", value, "berSet");
            return (Criteria) this;
        }

        public Criteria andBerSetNotEqualTo(String value) {
            addCriterion("ber_set <>", value, "berSet");
            return (Criteria) this;
        }

        public Criteria andBerSetGreaterThan(String value) {
            addCriterion("ber_set >", value, "berSet");
            return (Criteria) this;
        }

        public Criteria andBerSetGreaterThanOrEqualTo(String value) {
            addCriterion("ber_set >=", value, "berSet");
            return (Criteria) this;
        }

        public Criteria andBerSetLessThan(String value) {
            addCriterion("ber_set <", value, "berSet");
            return (Criteria) this;
        }

        public Criteria andBerSetLessThanOrEqualTo(String value) {
            addCriterion("ber_set <=", value, "berSet");
            return (Criteria) this;
        }

        public Criteria andBerSetLike(String value) {
            addCriterion("ber_set like", value, "berSet");
            return (Criteria) this;
        }

        public Criteria andBerSetNotLike(String value) {
            addCriterion("ber_set not like", value, "berSet");
            return (Criteria) this;
        }

        public Criteria andBerSetIn(List<String> values) {
            addCriterion("ber_set in", values, "berSet");
            return (Criteria) this;
        }

        public Criteria andBerSetNotIn(List<String> values) {
            addCriterion("ber_set not in", values, "berSet");
            return (Criteria) this;
        }

        public Criteria andBerSetBetween(String value1, String value2) {
            addCriterion("ber_set between", value1, value2, "berSet");
            return (Criteria) this;
        }

        public Criteria andBerSetNotBetween(String value1, String value2) {
            addCriterion("ber_set not between", value1, value2, "berSet");
            return (Criteria) this;
        }

        public Criteria andBerSortIsNull() {
            addCriterion("ber_sort is null");
            return (Criteria) this;
        }

        public Criteria andBerSortIsNotNull() {
            addCriterion("ber_sort is not null");
            return (Criteria) this;
        }

        public Criteria andBerSortEqualTo(Integer value) {
            addCriterion("ber_sort =", value, "berSort");
            return (Criteria) this;
        }

        public Criteria andBerSortNotEqualTo(Integer value) {
            addCriterion("ber_sort <>", value, "berSort");
            return (Criteria) this;
        }

        public Criteria andBerSortGreaterThan(Integer value) {
            addCriterion("ber_sort >", value, "berSort");
            return (Criteria) this;
        }

        public Criteria andBerSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("ber_sort >=", value, "berSort");
            return (Criteria) this;
        }

        public Criteria andBerSortLessThan(Integer value) {
            addCriterion("ber_sort <", value, "berSort");
            return (Criteria) this;
        }

        public Criteria andBerSortLessThanOrEqualTo(Integer value) {
            addCriterion("ber_sort <=", value, "berSort");
            return (Criteria) this;
        }

        public Criteria andBerSortIn(List<Integer> values) {
            addCriterion("ber_sort in", values, "berSort");
            return (Criteria) this;
        }

        public Criteria andBerSortNotIn(List<Integer> values) {
            addCriterion("ber_sort not in", values, "berSort");
            return (Criteria) this;
        }

        public Criteria andBerSortBetween(Integer value1, Integer value2) {
            addCriterion("ber_sort between", value1, value2, "berSort");
            return (Criteria) this;
        }

        public Criteria andBerSortNotBetween(Integer value1, Integer value2) {
            addCriterion("ber_sort not between", value1, value2, "berSort");
            return (Criteria) this;
        }

        public Criteria andBulkAddIsNull() {
            addCriterion("bulk_add is null");
            return (Criteria) this;
        }

        public Criteria andBulkAddIsNotNull() {
            addCriterion("bulk_add is not null");
            return (Criteria) this;
        }

        public Criteria andBulkAddEqualTo(String value) {
            addCriterion("bulk_add =", value, "bulkAdd");
            return (Criteria) this;
        }

        public Criteria andBulkAddNotEqualTo(String value) {
            addCriterion("bulk_add <>", value, "bulkAdd");
            return (Criteria) this;
        }

        public Criteria andBulkAddGreaterThan(String value) {
            addCriterion("bulk_add >", value, "bulkAdd");
            return (Criteria) this;
        }

        public Criteria andBulkAddGreaterThanOrEqualTo(String value) {
            addCriterion("bulk_add >=", value, "bulkAdd");
            return (Criteria) this;
        }

        public Criteria andBulkAddLessThan(String value) {
            addCriterion("bulk_add <", value, "bulkAdd");
            return (Criteria) this;
        }

        public Criteria andBulkAddLessThanOrEqualTo(String value) {
            addCriterion("bulk_add <=", value, "bulkAdd");
            return (Criteria) this;
        }

        public Criteria andBulkAddLike(String value) {
            addCriterion("bulk_add like", value, "bulkAdd");
            return (Criteria) this;
        }

        public Criteria andBulkAddNotLike(String value) {
            addCriterion("bulk_add not like", value, "bulkAdd");
            return (Criteria) this;
        }

        public Criteria andBulkAddIn(List<String> values) {
            addCriterion("bulk_add in", values, "bulkAdd");
            return (Criteria) this;
        }

        public Criteria andBulkAddNotIn(List<String> values) {
            addCriterion("bulk_add not in", values, "bulkAdd");
            return (Criteria) this;
        }

        public Criteria andBulkAddBetween(String value1, String value2) {
            addCriterion("bulk_add between", value1, value2, "bulkAdd");
            return (Criteria) this;
        }

        public Criteria andBulkAddNotBetween(String value1, String value2) {
            addCriterion("bulk_add not between", value1, value2, "bulkAdd");
            return (Criteria) this;
        }

        public Criteria andBulkFieldIsNull() {
            addCriterion("bulk_field is null");
            return (Criteria) this;
        }

        public Criteria andBulkFieldIsNotNull() {
            addCriterion("bulk_field is not null");
            return (Criteria) this;
        }

        public Criteria andBulkFieldEqualTo(String value) {
            addCriterion("bulk_field =", value, "bulkField");
            return (Criteria) this;
        }

        public Criteria andBulkFieldNotEqualTo(String value) {
            addCriterion("bulk_field <>", value, "bulkField");
            return (Criteria) this;
        }

        public Criteria andBulkFieldGreaterThan(String value) {
            addCriterion("bulk_field >", value, "bulkField");
            return (Criteria) this;
        }

        public Criteria andBulkFieldGreaterThanOrEqualTo(String value) {
            addCriterion("bulk_field >=", value, "bulkField");
            return (Criteria) this;
        }

        public Criteria andBulkFieldLessThan(String value) {
            addCriterion("bulk_field <", value, "bulkField");
            return (Criteria) this;
        }

        public Criteria andBulkFieldLessThanOrEqualTo(String value) {
            addCriterion("bulk_field <=", value, "bulkField");
            return (Criteria) this;
        }

        public Criteria andBulkFieldLike(String value) {
            addCriterion("bulk_field like", value, "bulkField");
            return (Criteria) this;
        }

        public Criteria andBulkFieldNotLike(String value) {
            addCriterion("bulk_field not like", value, "bulkField");
            return (Criteria) this;
        }

        public Criteria andBulkFieldIn(List<String> values) {
            addCriterion("bulk_field in", values, "bulkField");
            return (Criteria) this;
        }

        public Criteria andBulkFieldNotIn(List<String> values) {
            addCriterion("bulk_field not in", values, "bulkField");
            return (Criteria) this;
        }

        public Criteria andBulkFieldBetween(String value1, String value2) {
            addCriterion("bulk_field between", value1, value2, "bulkField");
            return (Criteria) this;
        }

        public Criteria andBulkFieldNotBetween(String value1, String value2) {
            addCriterion("bulk_field not between", value1, value2, "bulkField");
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