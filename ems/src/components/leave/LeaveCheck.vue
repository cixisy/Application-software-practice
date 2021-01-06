<template>
    <div style="width:800px;margin-left: 50px">
        <el-table
                :data="tableData"
                style="width: 100%"
                height="400"  highlight-current-row="true">
            <el-table-column
                    prop="date"
                    label="日期"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="申请人"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="desc"
                    label="请假描述"
                    width="250">
            </el-table-column>

            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template #default="scope">
                    <el-button @click="toDetails(scope.row)" type="text" size="small">查看</el-button>
                    <el-button @click="check(scope.row)" type="text" size="small">审批</el-button>
                </template>
            </el-table-column>
        </el-table>
        </div>
</template>

<script lang="js">
    import {defineComponent} from 'vue'

    export default defineComponent({
        name: "LeaveCheck",
        data() {
            return {
                tableData: [{
                    date: '2016-05-02',
                    name: '王小虎',
                    desc: '啦啦啦啦啊啦啦啦啦啦啦啦啦啦啦',
                    state:'通过'
                },{
                    date: '2016-05-02',
                    name: '王小虎',
                    desc: '啦啦啦啦啊啦啦啦啦啦啦啦啦啦啦',
                    state:'通过'
                },{
                    date: '2016-05-02',
                    name: '王小虎',
                    desc: '啦啦啦啦啊啦啦啦啦啦啦啦啦啦啦',
                    state:'通过'
                },{
                    date: '2016-05-02',
                    name: '王小虎',
                    desc: '啦啦啦啦啊啦啦啦啦啦啦啦啦啦啦',
                    state:'通过'
                },{
                    date: '2016-05-02',
                    name: '王小虎',
                    desc: '啦啦啦啦啊啦啦啦啦啦啦啦啦啦啦',
                    state:'通过'
                },{
                    date: '2016-05-02',
                    name: '王小虎',
                    desc: '啦啦啦啦啊啦啦啦啦啦啦啦啦啦啦',
                    state:'通过'
                },{
                    date: '2016-05-02',
                    name: '王小虎',
                    desc: '啦啦啦啦啊啦啦啦啦啦啦啦啦啦啦',
                    state:'通过'
                },{
                    date: '2016-05-02',
                    name: '王小虎',
                    desc: '啦啦啦啦啊啦啦啦啦啦啦啦啦啦啦',
                    state:'通过'
                }]
            }
        },
        methods:{
            toDetails(index){
                this.$router.push('/leavedetails')
            },
            check(){
                this.$prompt('请输入审批描述', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                }).then(({ value }) => {
                    this.$message({
                        type: 'success',
                        message: '提交成功'
                    });
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '取消输入'
                    });
                });
            },
        }
    })
</script>

<style scoped>

</style>