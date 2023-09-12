package com.fudian.szhjg.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TGrgzltjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TGrgzltjExample() {
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

        public Criteria andAjIdIsNull() {
            addCriterion("aj_id is null");
            return (Criteria) this;
        }

        public Criteria andAjIdIsNotNull() {
            addCriterion("aj_id is not null");
            return (Criteria) this;
        }

        public Criteria andAjIdEqualTo(String value) {
            addCriterion("aj_id =", value, "ajId");
            return (Criteria) this;
        }

        public Criteria andAjIdNotEqualTo(String value) {
            addCriterion("aj_id <>", value, "ajId");
            return (Criteria) this;
        }

        public Criteria andAjIdGreaterThan(String value) {
            addCriterion("aj_id >", value, "ajId");
            return (Criteria) this;
        }

        public Criteria andAjIdGreaterThanOrEqualTo(String value) {
            addCriterion("aj_id >=", value, "ajId");
            return (Criteria) this;
        }

        public Criteria andAjIdLessThan(String value) {
            addCriterion("aj_id <", value, "ajId");
            return (Criteria) this;
        }

        public Criteria andAjIdLessThanOrEqualTo(String value) {
            addCriterion("aj_id <=", value, "ajId");
            return (Criteria) this;
        }

        public Criteria andAjIdLike(String value) {
            addCriterion("aj_id like", value, "ajId");
            return (Criteria) this;
        }

        public Criteria andAjIdNotLike(String value) {
            addCriterion("aj_id not like", value, "ajId");
            return (Criteria) this;
        }

        public Criteria andAjIdIn(List<String> values) {
            addCriterion("aj_id in", values, "ajId");
            return (Criteria) this;
        }

        public Criteria andAjIdNotIn(List<String> values) {
            addCriterion("aj_id not in", values, "ajId");
            return (Criteria) this;
        }

        public Criteria andAjIdBetween(String value1, String value2) {
            addCriterion("aj_id between", value1, value2, "ajId");
            return (Criteria) this;
        }

        public Criteria andAjIdNotBetween(String value1, String value2) {
            addCriterion("aj_id not between", value1, value2, "ajId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("`state` like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("`state` not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andYhxmIsNull() {
            addCriterion("yhxm is null");
            return (Criteria) this;
        }

        public Criteria andYhxmIsNotNull() {
            addCriterion("yhxm is not null");
            return (Criteria) this;
        }

        public Criteria andYhxmEqualTo(String value) {
            addCriterion("yhxm =", value, "yhxm");
            return (Criteria) this;
        }

        public Criteria andYhxmNotEqualTo(String value) {
            addCriterion("yhxm <>", value, "yhxm");
            return (Criteria) this;
        }

        public Criteria andYhxmGreaterThan(String value) {
            addCriterion("yhxm >", value, "yhxm");
            return (Criteria) this;
        }

        public Criteria andYhxmGreaterThanOrEqualTo(String value) {
            addCriterion("yhxm >=", value, "yhxm");
            return (Criteria) this;
        }

        public Criteria andYhxmLessThan(String value) {
            addCriterion("yhxm <", value, "yhxm");
            return (Criteria) this;
        }

        public Criteria andYhxmLessThanOrEqualTo(String value) {
            addCriterion("yhxm <=", value, "yhxm");
            return (Criteria) this;
        }

        public Criteria andYhxmLike(String value) {
            addCriterion("yhxm like", value, "yhxm");
            return (Criteria) this;
        }

        public Criteria andYhxmNotLike(String value) {
            addCriterion("yhxm not like", value, "yhxm");
            return (Criteria) this;
        }

        public Criteria andYhxmIn(List<String> values) {
            addCriterion("yhxm in", values, "yhxm");
            return (Criteria) this;
        }

        public Criteria andYhxmNotIn(List<String> values) {
            addCriterion("yhxm not in", values, "yhxm");
            return (Criteria) this;
        }

        public Criteria andYhxmBetween(String value1, String value2) {
            addCriterion("yhxm between", value1, value2, "yhxm");
            return (Criteria) this;
        }

        public Criteria andYhxmNotBetween(String value1, String value2) {
            addCriterion("yhxm not between", value1, value2, "yhxm");
            return (Criteria) this;
        }

        public Criteria andJggxIsNull() {
            addCriterion("jggx is null");
            return (Criteria) this;
        }

        public Criteria andJggxIsNotNull() {
            addCriterion("jggx is not null");
            return (Criteria) this;
        }

        public Criteria andJggxEqualTo(String value) {
            addCriterion("jggx =", value, "jggx");
            return (Criteria) this;
        }

        public Criteria andJggxNotEqualTo(String value) {
            addCriterion("jggx <>", value, "jggx");
            return (Criteria) this;
        }

        public Criteria andJggxGreaterThan(String value) {
            addCriterion("jggx >", value, "jggx");
            return (Criteria) this;
        }

        public Criteria andJggxGreaterThanOrEqualTo(String value) {
            addCriterion("jggx >=", value, "jggx");
            return (Criteria) this;
        }

        public Criteria andJggxLessThan(String value) {
            addCriterion("jggx <", value, "jggx");
            return (Criteria) this;
        }

        public Criteria andJggxLessThanOrEqualTo(String value) {
            addCriterion("jggx <=", value, "jggx");
            return (Criteria) this;
        }

        public Criteria andJggxLike(String value) {
            addCriterion("jggx like", value, "jggx");
            return (Criteria) this;
        }

        public Criteria andJggxNotLike(String value) {
            addCriterion("jggx not like", value, "jggx");
            return (Criteria) this;
        }

        public Criteria andJggxIn(List<String> values) {
            addCriterion("jggx in", values, "jggx");
            return (Criteria) this;
        }

        public Criteria andJggxNotIn(List<String> values) {
            addCriterion("jggx not in", values, "jggx");
            return (Criteria) this;
        }

        public Criteria andJggxBetween(String value1, String value2) {
            addCriterion("jggx between", value1, value2, "jggx");
            return (Criteria) this;
        }

        public Criteria andJggxNotBetween(String value1, String value2) {
            addCriterion("jggx not between", value1, value2, "jggx");
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

        public Criteria andJianShuIsNull() {
            addCriterion("jian_shu is null");
            return (Criteria) this;
        }

        public Criteria andJianShuIsNotNull() {
            addCriterion("jian_shu is not null");
            return (Criteria) this;
        }

        public Criteria andJianShuEqualTo(Integer value) {
            addCriterion("jian_shu =", value, "jianShu");
            return (Criteria) this;
        }

        public Criteria andJianShuNotEqualTo(Integer value) {
            addCriterion("jian_shu <>", value, "jianShu");
            return (Criteria) this;
        }

        public Criteria andJianShuGreaterThan(Integer value) {
            addCriterion("jian_shu >", value, "jianShu");
            return (Criteria) this;
        }

        public Criteria andJianShuGreaterThanOrEqualTo(Integer value) {
            addCriterion("jian_shu >=", value, "jianShu");
            return (Criteria) this;
        }

        public Criteria andJianShuLessThan(Integer value) {
            addCriterion("jian_shu <", value, "jianShu");
            return (Criteria) this;
        }

        public Criteria andJianShuLessThanOrEqualTo(Integer value) {
            addCriterion("jian_shu <=", value, "jianShu");
            return (Criteria) this;
        }

        public Criteria andJianShuIn(List<Integer> values) {
            addCriterion("jian_shu in", values, "jianShu");
            return (Criteria) this;
        }

        public Criteria andJianShuNotIn(List<Integer> values) {
            addCriterion("jian_shu not in", values, "jianShu");
            return (Criteria) this;
        }

        public Criteria andJianShuBetween(Integer value1, Integer value2) {
            addCriterion("jian_shu between", value1, value2, "jianShu");
            return (Criteria) this;
        }

        public Criteria andJianShuNotBetween(Integer value1, Integer value2) {
            addCriterion("jian_shu not between", value1, value2, "jianShu");
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