import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Home from "../views/Home.vue";
import Products from "../views/Products.vue";
import Services from "../views/Services.vue";
import DetailService from "../views/DetailService.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
  {
    path: "/products",
    name: "Products",
    component: Products,
  },
  {
    path: "/services",
    name: "Services",
    component: Services,
  },
  {
    path: "/services/detail/:id",
    name: "Detail",
    props: true,
    component: DetailService,
  },
  {
    path: "/users/login",
    name: "Login",
    component: () =>
        import(/* webpackChunkName: "about" */ "../views/Login.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
