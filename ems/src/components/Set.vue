<template>
    <div style="width: 1200px;">
    <el-space wrap>
            <el-card class="box-card" v-for="(item,index) in test" :key="index" style="width: 300px;margin-right: 50px">
                <template #header>
                    <div class="clearfix">
                        <span style="font-size: 20px; text-align: left" >编号:{{item.epnum}}</span>
                        <el-button style="float: right; padding: 3px 0" type="text" @click="modify(index)">修改</el-button>
                    </div>
                </template>
                <div  class="text item" style="text-align: left">
                   姓名: {{item.ename}}
                </div>
                <div  class="text item" style="text-align: left">
                    部门: {{item.dep_num}}
                </div>
                <div  class="text item" style="text-align: left">
                   密码: {{item.pwd}}
                </div>
                <div  class="text item" style="text-align: left">
                   性别: {{item.sex}}
                </div>
            </el-card>
    </el-space>
    </div>
    <el-backtop  :bottom="100">
        <div
                style="{
        height: 100%;
        width: 100%;
        background-color: #f2f5f6;
        box-shadow: 0 0 6px rgba(0,0,0, .12);
        text-align: center;
        line-height: 40px;
        color: #1989fa;
      }"
        >
            UP
        </div>

    </el-backtop>

    <el-dialog title="信息修改" v-model="dialogVisible" width="500px">
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="编号">
                <el-input v-model="form.id"></el-input>
            </el-form-item>
            <el-form-item label="姓名">
                <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="部门">
                <el-input v-model="form.pid"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="form.password"></el-input>
            </el-form-item>
			<el-form-item label="上级员工">
			    <el-input v-model="form.spNum"></el-input>
			</el-form-item>
			<el-form-item label="是否升职" prop="flag">
			    <el-radio v-model="form.flag" label="1">升职</el-radio>
			    <el-radio v-model="form.flag" label="0">降职</el-radio>
			</el-form-item>
        </el-form>
        <span  class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="confirm">确 定</el-button>
      </span>
    </el-dialog>

</template>

<script lang="js">
    /* eslint-disable */
    import {defineComponent} from 'vue'

    export default defineComponent({
        name: "Set",

        data(){
            return {
                dialogVisible:false,
                index:0,
                form: {
                    id:1,
                    name: '',
                    pid:1,
                    password:'',
					spNum:'',
					flag:'0'
                },
				test:[]
            };
        },
		beforeRouteEnter: (to, from, next) => {
			next(vm => {
				vm.getParams();
			});
		},
        methods: {
			getParams(){
				this.$http.get("http://localhost:8081/ems/employee/queryAllEmployeeInfo").then((res)=>{
					this.test = res.data;
				})
			},
            modify(index) {

                this.index = index
				this.form.id = this.test[index].epnum
				this.form.name = this.test[index].ename
				this.form.pid = this.test[index].dep_num
				this.form.password = this.test[index].pwd
				this.form.spNum = this.test[index].superior_epnum
				this.form.flag = ''+this.test[index].superior_mark
				this.dialogVisible = true;



            },
            confirm(){
                this.$http.get("http://localhost:8081/ems/employee/updateEmployeeInfo?id="+this.test[this.index].epnum+"&nId="+this.form.id
				+"&nName="+this.form.name+"&ndNum="+this.form.pid+"&nPwd="+this.form.password+"&nsNum="+this.form.spNum+"&nMark="+this.form.flag
				).then((res)=>{
					this.$http.get("http://localhost:8081/ems/employee/queryAllEmployeeInfo").then((res)=>{
						this.test = res.data;
					})
				})




                this.dialogVisible = false
            }
    }

    })

</script>

<style scoped>
    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }

    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 480px;
    }
</style>
