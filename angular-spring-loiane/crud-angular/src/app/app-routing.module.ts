import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'courses',
    pathMatch: 'full',
  },
  {
    // lazy loading
    path: 'courses',
    loadChildren: () =>
      import('./courses/courses.module').then((m) => m.CoursesModule),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
