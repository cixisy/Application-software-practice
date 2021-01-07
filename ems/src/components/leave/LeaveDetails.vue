<template>
    <div style="background-color: white;padding-top: 10px;width:1000px;padding-bottom: 10px">

        <el-col :span="2">
            <el-button type="primary" icon="el-icon-back" @click="goBack"></el-button>
        </el-col>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm"
                 style="margin-left: 200px;margin-top: 20px" disabled>
            <el-form-item label="申请时间">
                <el-col :span="11">
                    <el-form-item>
                        <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.currenttime"
                                        style="width: 100%;"></el-date-picker>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item label="员工编号" style="width: 330px;">
                <el-input v-model="ruleForm.number" placeholder="请输入员工编号"></el-input>
            </el-form-item>
            <el-form-item label="请假类型" style="width: 330px;">
                <el-select v-model="ruleForm.type" placeholder="请选择请假类型">
                    <el-option label="事假" value="01"></el-option>
                    <el-option label="病假" value="02"></el-option>
                    <el-option label="出差" value="03"></el-option>
                    <el-option label="带薪休假" value="04"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="开始时间" required>
                <el-col :span="11">
                    <el-form-item>
                        <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.starttime"
                                        style="width: 100%;"></el-date-picker>
                    </el-form-item>
                </el-col>
            </el-form-item>
            <el-form-item label="结束时间" required>
                <el-col :span="11">
                    <el-form-item>
                        <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.lasttime"
                                        style="width: 100%;"></el-date-picker>
                    </el-form-item>
                </el-col>
            </el-form-item>

            <el-form-item label="请假原因">
                <el-col :span="11">
                    <el-input type="textarea" v-model="ruleForm.desc1" placeholder="请说明请假原因" style="width: 400px;"
                              :rows="3"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item label="审批描述">
                <el-col :span="11">
                    <el-input type="textarea" v-model="ruleForm.desc2" placeholder="请说明请假原因" style="width: 400px;"
                              :rows="3"></el-input>
                </el-col>
            </el-form-item>
        </el-form>
    </div>
</template>

<script lang="ts">
    import {defineComponent} from 'vue'

    export default defineComponent({
        name: "LeaveDetails",

        data() {
            return {
                ruleForm: {
                    currenttime: '',
                    data1: '',
                    type: '',
                    starttime: '',
                    lasttime: '',
                    delivery: false,
                    resource: '',
                    desc1: '',
                    desc2: '',
                    number: 12
                },
                rules: {
                    name: [
                        {required: true, message: '请输入活动名称', trigger: 'blur'},
                        {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                    ],
                    region: [
                        {required: true, message: '请选择活动区域', trigger: 'change'}
                    ],
                    date1: [
                        {type: 'date', required: true, message: '请选择日期', trigger: 'change'}
                    ],
                    date2: [
                        {type: 'date', required: true, message: '请选择时间', trigger: 'change'}
                    ],
                    type: [
                        {type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change'}
                    ],
                    resource: [
                        {required: true, message: '请选择活动资源', trigger: 'change'}
                    ],
                    desc: [
                        {required: true, message: '请填写活动形式', trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            goBack() {
                this.$router.go(-1);
            },
        }
    })
</script>

<style scoped>

</style>
