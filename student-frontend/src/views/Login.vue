<template>
  <div>
    <form action="">
      <input type="text" v-model="username"><br>
      <input type="password" v-model="password"><br>
      <input type="submit" value="登录" @click.prevent="login">
      <p>没有帐号，<router-link to="/register">立即注册</router-link></p>
    </form>
  </div>
</template>

<script>
  export default {
    name: "Login",
    data() {
      return {
        username: "",
        password: ""
      }
    },
    methods: {
      login() {
        let params = new URLSearchParams()
        params.append("username", this.username)
        params.append("password", this.password)

        fetch("/auth/login", {
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
