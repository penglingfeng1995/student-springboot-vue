<template>
    <div>
      <form action="">
        <input type="text" v-model="username"><br>
        <input type="password" v-model="password"><br>
        <input type="submit" value="注册" @click.prevent="register">
      </form>
    </div>
</template>

<script>
    export default {
        name: "Register",
      data(){
          return {
            username:"",
            password:""
          }
      },
      methods:{
          register(){
            let params = new URLSearchParams()
            params.append("username", this.username)
            params.append("password", this.password)

            fetch("/auth/register", {
              method: "post",
              body: params
            }).then(res => res.json()).then(json => {
              if (json.status) {
                this.$router.push("/main")
              } else {
                alert(json.msg)
              }
            })
          }
      }
    }
</script>

<style scoped>

</style>
