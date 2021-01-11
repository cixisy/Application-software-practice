<template>
    <div>
        <el-form ref="overtimeinfo" :model="overtimeinfo" disabled="true" label-width="120px"
                 size="mini" style='width: 560px'>
            <el-form-item label="工号">
                <el-input v-model="overtimeinfo.epnum"></el-input>
            </el-form-item>
            <el-form-item label="加班类型">
                <el-select v-model="overtimeinfo.o_type" placeholder="请选择活动区域">
                    <el-option label="常规加班" value=0></el-option>
                    <el-option label="节假日加班" value=1></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="加班开始时间">
                <el-col :span="11">
                    <el-date-picker type="date" placeholder="选择日期" v-model="stime0"
                                    style="width: 100%;"></el-date-picker>
                </el-col>
                <el-col class="line" :span="2">-</el-col>
                <el-col :span="11">
                    <el-time-picker placeholder="选择时间" v-model="etime0" style="width: 100%;"></el-time-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="加班结束时间">
                <el-col :span="11">
                    <el-date-picker type="date" placeholder="选择日期" v-model="stime1"
                                    style="width: 100%;"></el-date-picker>
                </el-col>
                <el-col class="line" :span="2">-</el-col>
                <el-col :span="11">
                    <el-time-picker placeholder="选择时间" v-model="etime1" style="width: 100%;"></el-time-picker>
                </el-col>
            </el-form-item>

            <el-form-item label="加班描述">
                <el-input type="textarea" v-model="overtimeinfo.o_descrip"></el-input>
            </el-form-item>

        </el-form>
        <el-form ref="overtimeinfo" :model="overtimeinfo" label-width="120px"
                 size="mini" style='width: 560px'>
            <el-form-item label="审批描述">
                <el-input type="textarea" v-model="overtimeinfo.o_comfirm_descrip"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">提交</el-button>
                <el-button type="primary" @click="goback">返回</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>

<script>
    /* eslint-disable */
    import moment from "moment";

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
                stime0: '',
                etime0: '',
                stime1: '',
                etime1: '',
                overtimeinfo:{
                    epnum: 20210001,
                    o_type: 1,
                    o_start: '',
                    o_end: '',
                    o_total: 300,
                    o_descrip: 'text',
                    o_mark: '通过',
                    o_confirm_person: '',
                    o_comfirm_descrip: '',
                    apply_time: '2020-06-03 00:00:00',
                },
                id:'',
                a_time:'',
                name :''
            }
        },
        beforeRouteEnter: (to, from, next) => {
            next(vm => {
                vm.getParams();
            });
        },
        methods: {
            getParams() {
                this.id = this.$route.query.id;
                this.overtimeinfo.epnum= this.$route.query.epnum;
                this.overtimeinfo.o_type=this.$route.query.o_type,
                    this.overtimeinfo.o_start= this.$route.query.o_start,
                    this.overtimeinfo.o_end=this.$route.query.o_end,
                    this.overtimeinfo.o_total= this.$route.query.o_total,
                    this.overtimeinfo.o_descrip= this.$route.query.o_descrip,
                    this.overtimeinfo.o_mark= this.$route.query.o_mark,
                    this.overtimeinfo.o_confirm_person= this.$route.query.o_confirm_person,
                    this.overtimeinfo.o_comfirm_descrip= this.$route.query.o_comfirm_descrip,
                    this.overtimeinfo.apply_time= this.$route.query.apply_time
                console.log("审批界面")
                console.log(this.id)
                console.log( this.overtimeinfo);
            },
            onSubmit() {
                let a0, a1;
                console.log("hahha")
                this.$http.get("http://localhost:8081/ems/employee//queryEmployeeInfoById?id=" + this.id).then((res)=>{
                    console.log( res.data.ename)
                    this.overtimeinfo.o_confirm_person = res.data.ename;
                    this.overtimeinfo.o_mark = 1
                    console.log(this.overtimeinfo.o_confirm_person)

                    this.$confirm('是否提交请假信息', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        console.log("jahsai")
                        console.log(this.overtimeinfo)
                        console.log("jahsai")
                        this.axios({
                            method:'post',
                            url:"http://localhost:8081/ems/employee/updateOvertime",
                            data:this.overtimeinfo,

                        }).then((res)=>{
                            this.$alert('申请已提交！', '提示', {
                                confirmButtonText: '确定',
                                callback: action => {
                                    this.$message({
                                        type: 'success',
                                        message: '提交成功!'
                                    });
                                }
                            });

                        });


                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消'
                        });
                    });
                })



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
