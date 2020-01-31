<template>
    <div>主页
      <student-table></student-table>
    </div>
</template>

<script>
    import StudentTable from "../components/StudentTable"
    import axios from 'axios'
    export default {
        name: "Main",
      components: {StudentTable},
      mounted() {
          axios.get("/auth/isLogin").then(res=>{
            if(!res.data.isLogin){
                this.$router.push("/login")
            }
          })
      }
    }
</script>

<style scoped>

</style>
