<template>
    <div id="guoguo" style="width:700px;margin-left: 100px;padding-top: 20px">
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm"
                 style="margin-left: 100px;margin-top: 20px">
            <el-form-item label="员工编号" style="width: 330px;" required>
                <el-input v-model="ruleForm.id" placeholder="请输入员工编号"></el-input>
            </el-form-item>
            <el-form-item label="请假类型" style="width: 330px;" required>
                <el-select v-model="ruleForm.type" placeholder="请选择请假类型">
                    <el-option label="事假" value="01"></el-option>
                    <el-option label="病假" value="02"></el-option>
                    <el-option label="出差" value="03"></el-option>
                    <el-option label="带薪休假" value="04"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="开始时间" style="color: #030202; " required>

                <el-col :span="11">
                    <el-form-item>
                        <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.starttime"
                                        style=" width: 100%;"></el-date-picker>
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
                <el-col :span="4">
                    <el-input type="textarea" v-model="ruleForm.desc" placeholder="请说明请假原因" style="width: 400px;"
                              :rows="3"></el-input>
                </el-col>
            </el-form-item>
            <el-form-item>
                <el-col :span="11">
                    <el-button type="primary" @click="submitForm">提交</el-button>
                </el-col>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    import {defineComponent} from 'vue'

    export default defineComponent({
        name: "LeaveApply",
        data() {
            return {
				id:'',
                ruleForm: {
                    type: '',
                    starttime: '',
                    lasttime: '',
                    desc: '',
                    id: 12
                },
                rules: {
                    starttime: [
                        {type: 'date', required: true, message: '请选择日期', trigger: 'change'}
                    ],
                    lasttime: [
                        {type: 'date', required: true, message: '请选择时间', trigger: 'change'}
                    ],
                    type: [
                        {type: 'array', required: true, message: '请至少选择一个类型', trigger: 'change'}
                    ]
                    
                }
            };
        },
		beforeRouteEnter: (to, from, next) => {
			next(vm => {
				vm.getParams();
			});
		},
        methods: {
			getParams() {
				this.id = this.$route.query.id;
				this.ruleForm.id = this.id;
				console.log(this.id);
			},
            submitForm(formName) {
                this.$confirm('是否提交请假信息', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
					this.axios({
					  method:'post',
					  url:"http://localhost:8081/ems/employee/leaveApply",
					  data:this.ruleForm,
					
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
					  this.flash();
					});
                    
					
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消'
                    });
                });
            },
			flash(){
				this.ruleForm.type = '',
				this.ruleForm.starttime = '',
				this.ruleForm.lasttime = '',
				this.ruleForm.desc = ''
			},
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
        // data() {
        //     return {
        //         form: {
        //             date1: '',
        //             number: '',
        //             region: '',
        //             sdate1:'',
        //             sdate2:'',
        //             jdate1:'',
        //             jdate2:'',
        //             desc: '',
        //         },
        //         form1:{
        //             date1: '',
        //             id: '',
        //             region: '',
        //             sdate:'',
        //             jdate:'',
        //             desc:'',
        //         }
        //     }
        // },
        // methods: {
        //     onSubmit() {
        //         const that = this;
        //         this.form1.date1=this.form.date1;
        //         this.form1.id=this.form.number;
        //         this.form1.region=this.form.region;
        //         this.form1.sdate=this.form.sdate1+' '+this.form.sdate2;
        //         this.form1.jdate=this.form.jdate1+' '+this.form.jdate2;
        //         this.form1.desc=this.form.desc;
        //         this.axios({
        //             method:'post',
        //             url:"http://localhost:8081/employee/apply",
        //             data:that.form1,
        //
        //         }).then((res)=>{
        //             this.$alert('申请已提交！', '提示', {
        //                 confirmButtonText: '确定',
        //                 callback: action => {
        //                     this.$message({
        //                         type: 'info',
        //                         message: `action: ${ action }`
        //                     });
        //                 }
        //             });
        //         });
        //     }
        // }
    })
</script>

<style scoped>
    #guoguo {
        background-color: white;

    }
</style>
