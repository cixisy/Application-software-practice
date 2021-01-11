<template>
    <div class="infinite-list-wrapper"
         style="overflow:auto;background-color:white;width:600px;margin-left: 100px;padding-top: 20px">
        <el-form ref="overtimeinfo" :model="overtimeinfo" label-width="120px"
                 style='width: 560px'>
            <el-form-item label="工号">
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
                    <el-date-picker type="date" placeholder="选择日期" v-model="stime0"
                                    style="width: 100%;"></el-date-picker>
                </el-col>
                <el-col class="line" :span="2">-</el-col>
                <el-col :span="11">
                    <el-time-picker placeholder="选择时间" v-model="stime1" style="width: 100%;"></el-time-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="加班结束时间">
                <el-col :span="11">
                    <el-date-picker type="date" placeholder="选择日期" v-model="etime0"
                                    style="width: 100%;"></el-date-picker>
                </el-col>
                <el-col class="line" :span="2">-</el-col>
                <el-col :span="11">
                    <el-time-picker placeholder="选择时间" v-model="etime1" style="width: 100%;"></el-time-picker>
                </el-col>
            </el-form-item>

            <el-form-item label="加班描述">
                <el-input type="textarea" v-model="overtimeinfo.odescrip"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">提交</el-button>

            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import {defineComponent} from "vue";
    import moment from "moment"
    export default defineComponent({
        name: "WorkOvertimeApply",
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
                overtimeinfo: {
                    epnum: 1,
                    otype: 1,
                    ostart: '',
                    oend: '',
                    ototal: 300,
                    odescrip: 'text',
                    omark: 0,
                    oconfirmperson: '',
                    ocomfirmdescrip: '',
                    applytime: '2020-06-03 00:00:00',
                },
                id:'',
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
                this.overtimeinfo.epnum  = this.id;
                console.log(this.id);
            },
            timeadd(a0,a1){
                a0 = moment(a0).format("YYYY-MM-DD") +' '+moment(a1).format("HH:mm:ss");
                return a0;
            },
            ototalcp(a,b){
                let start;
                // eslint-disable-next-line prefer-const
                   start = new Date(a);
                const endTime = new Date(b);
                const day = ( endTime.getTime() - start.getTime() )
                const c  = Math.floor(day/1000/60)//得到分钟数

                this.overtimeinfo.ototal = c/60
            },
            onSubmit() {
                let a0, a1;

                // eslint-disable-next-line prefer-const
                a0 = this.timeadd(this.stime0,this.stime1);
                // eslint-disable-next-line prefer-const
                a1 = this.timeadd(this.etime0,this.etime1);
                this.ototalcp(a0,a1);
                console.log(a0,a1);
                this.overtimeinfo.ostart = a0;
                this.overtimeinfo.oend = a1;
                this.overtimeinfo.applytime = moment(new Date()).format("YYYY-MM-DD HH:mm:ss")
                console.log(this.overtimeinfo);

                this.$confirm('是否提交请假信息', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.axios({
                        method:'post',
                        url:"http://localhost:8081/ems/employee/overtimeApply",
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

            }
        }


    })
</script>

<style scoped>

</style>
