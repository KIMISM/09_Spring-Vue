import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../pages/HomePage.vue';
import authRotes from './auth';
import boardRotes from './board';
import travelRotes from './travel';
import galleryRotes from './gallery';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // ...은 전개 연산자이므로 해당 컴포넌트가 반환한 배열 안쪽의 객체들만 가져온다
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage,
    },
    ...authRotes,
    ...boardRotes,
    ...travelRotes,
    ...galleryRotes,
  ],
});

export default router;
