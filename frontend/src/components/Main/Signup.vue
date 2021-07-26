<template>
  <!-- signup box start -->
  <div id="second">
    <div class="myform form ">
      <div class="logo mb-3">
        <div class="col-md-12 text-center">
          <h1>Signup</h1>
        </div>
      </div>
      <form 
        @submit.prevent="onSubmit" 
        name="registration"
      >
        <div class="form-group">
          <label for="exampleInputEmail1">이름</label>
          <input type="text"  name="username" v-model="credential.username"
          class="form-control" id="username" aria-describedby="emailHelp" placeholder="Enter Username">
        </div>
        <div class="form-group">
          <div class="d-flex justify-content-between">
            <label for="exampleInputEmail1">닉네임</label> <button id="nicknameCheck" @click="nicknameDuplicateCheck" class="border-0 bg-transparent text-primary" v-bind="{ 'disabled' : duplicate.nicknameCheck }">닉네임 중복확인</button>
          </div>
          <input type="text"  name="nickname" v-model="credential.nickname"
          class="form-control" id="nickname" aria-describedby="nicknameHelp" placeholder="Enter Nickname">
        </div>
        <div class="form-group">
          <div class="d-flex justify-content-between">
            <label for="exampleInputEmail1">이메일</label> <button id="usernameCheck" @click="emailDuplicateCheck" class="border-0 bg-transparent text-primary" v-bind="{ 'disabled' : duplicate.emailCheck }">이메일 중복확인</button>
          </div>
          <input type="email" name="email" v-validate="'required|email'" v-model="credential.email" data-vv-as="Email"
          class="form-control" :class="{error: errors.has('email')}"  id="email" aria-describedby="emailHelp" placeholder="Enter email">
          <span class="error" v-if="errors.has('email')">{{errors.first('email')}}</span>
        </div>
        <div class="form-group">
          <label for="">Password</label>
          <input type="password" ref="password" name="password" v-validate="'required|min:6'" v-model="credential.password" data-vv-as="Password"
          class="form-control" :class="{error: errors.has('password')}"  id="password" aria-describedby="password" placeholder="Enter Password">
          <span class="error" v-if="errors.has('password')">{{errors.first('password')}}</span>
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Password Confirmation</label>
          <input type="password" name="passwordConfirmation" v-validate="'confirmed:password'" v-model="credential.passwordConfirmation" data-vv-as="Password Confirmation"
          class="form-control" :class="{error: errors.has('passwordConfirmation')}"  id="passwordConfirmation" aria-describedby="passwordConfirmationHelp" placeholder="Enter Password One More">
          <span class="error" v-if="errors.has('passwordConfirmation')">{{errors.first('passwordConfirmation')}}</span>
        </div>
        <!-- <div class="form-group">
          <label for="exampleInputEmail1">Password</label>
          <input type="password" name="password" v-model="credential.password"
          id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Enter Password">
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Password Confirmation</label>
          <input type="password" name="passwordfirmation" v-model="credential.passwordConfirmation"
          id="passwordConfirmation"  class="form-control" aria-describedby="emailHelp" placeholder="Enter Password Again">
        </div> -->
        <div class="col-md-12 text-center mb-3">
          <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm" @click.prevent="signup">Get Started!</button>
        </div>
        <div class="col-md-12 ">
          <div class="form-group">
              <p class="text-center"><a href="#" @click="change">Already have an account?</a></p>
          </div>
        </div>
      </form>
    </div>
  </div>
  <!-- signup box end -->
</template>
<script>
import Vue from 'vue'
import axios from 'axios'

const AUTH_SERVER_URL = process.env.VUE_APP_SERVER_URL

import * as VeeValidate from 'vee-validate';
import ko from 'vee-validate/dist/locale/ko.js'

ko.messages.email = (field) => `${field}은/는 올바른 이메일 형식이어야 합니다.`
ko.messages.required = (field) => `${field}이/가 필요합니다.`

ko.messages.password = (field) => `${field}는 최소 6글자 여야합니다.`

const config = {
  locale: 'ko',
  dictionary: {
    ko
  }
}

Vue.use(VeeValidate, config)

export default {
  name: 'Signup',

  data: function () {
    return {
      credential: {
        username: null,
        nickname: null,
        email: null,
        password: null,
        passwordConfirmation: null,
      },
      duplicate: {
        emailCheck: false,
        nicknameCheck: false
      }
    }
  },

  methods: {
    change: function () {
      this.$emit('change')
    },

    onSubmit() {
      this.$validator.validateAll()

      if (!this.errors.any()) {
        if (!this.duplicate.emailCheck) {
          alert('이메일 중복확인을 해주세요!')
        }

        if (!this.duplicate.nicknameCheck) {
          alert('닉네임 중복확인을 해주세요')          
        }

        
      }
    },

    nicknameDuplicateCheck() {
      axios({
        method: 'get',
        url: `${AUTH_SERVER_URL}/checkNickname/${this.credential.nickname}`,
        data: this.credential.nickname
      })
        .then(() => {
          this.duplicate.nicknameCheck = true
          alert('닉네임 중복체크 완료!')
        })
    },
    
    emailDuplicateCheck() {
      axios({
        method: 'get',
        url: `${AUTH_SERVER_URL}/checkEmail/${this.credential.email}`,
      })
        .then(() => {
          this.duplicate.emailCheck = true
          alert('이메일 중복체크 완료!')
        })
    },
  }
}

</script>

<style>
@import url('https://unpkg.com/semantic-ui-css@2.2.9/semantic.css');

span.error {
  color: #9F3A38;
}

</style>