const User = {
  //状态
  state: sessionStorage.getItem("state") ? JSON.parse(sessionStorage.getItem("state")) : {
    user: {
      username: "",
    }
  },
//获取状态
  getters: {
    getUser(state) {
      return state.user;
    }
  },
//同步改变状态
  mutations: {
    updateUser(state, user) {
      state.user = user;
    }
  },

//异步改变状态
  actions: {
    asyncUpdateUser(context, user) {
      context.commit('updateUser', user);
    }
  },
};
export default User;
