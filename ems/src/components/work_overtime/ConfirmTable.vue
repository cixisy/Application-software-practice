<template>
    <div>
        <el-form ref="overtimeinfo" :model="overtimeinfo"  disabled="true" label-width="120px"
                 size="mini" style = 'width: 560px'>
            <el-form-item label="工号" >
                <el-input v-model="overtimeinfo.epnum"></el-input>
            </el-form-item>
            <el-form-item label="加班类型">
                <el-select v-model="overtimeinfo.otype" placeholder="请选择活动区域">
                    <el-option label="常规加班" value=0></el-option>
                    <el-option label="节假日加班" value=1></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="加班开始时间">
                <el-col :span="11">
                    <el-date-picker type="date" placeholder="选择日期" v-model="stime0" style="width: 100%;"></el-date-picker>
                </el-col>
                <el-col class="line" :span="2">-</el-col>
                <el-col :span="11">
                    <el-time-picker placeholder="选择时间" v-model="etime0" style="width: 100%;"></el-time-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="加班结束时间">
                <el-col :span="11">
                    <el-date-picker type="date" placeholder="选择日期" v-model="stime1" style="width: 100%;"></el-date-picker>
                </el-col>
                <el-col class="line" :span="2">-</el-col>
                <el-col :span="11">
                    <el-time-picker placeholder="选择时间" v-model="etime1" style="width: 100%;"></el-time-picker>
                </el-col>
            </el-form-item>

            <el-form-item label="加班描述">
                <el-input type="textarea" v-model="overtimeinfo.odescrip"></el-input>
            </el-form-item>

        </el-form>
        <el-form ref="overtimeinfo" :model="overtimeinfo"   label-width="120px"
                 size="mini" style = 'width: 560px'>
            <el-form-item label="审批描述">
                <el-input type="textarea" v-model="overtimeinfo.ocomfirmdescrip"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit" >提交</el-button>
                <el-button type="primary" @click="goback">返回</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>

<script>
    export default {
        name: "ConfirmTable",
        data() {
            return {
                form: {
                    name: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                },
                stime0 :'',
                etime0  : '',
                stime1 :'',
                etime1  : '',
                overtimeinfo: {
                    epnum : 1,
                    otype : 1,
                    ostart : '',
                    oend :'',
                    ototal : 300,
                    odescrip :'text',
                    omark :0,
                    oconfirmperson :'',
                    ocomfirmdescrip :'',
                    applytime : '2020-06-03 00:00:00',
                },
            }
        },
        methods: {
            onSubmit() {
                console.log('submit!');
            },
            goback() {
                this.$router.go(-1);//返回上一层
            }
        }
    }
</script>

<style scoped>

</style>
