import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

//Componentes:
import { MonitorAmbientesComponent } from './components/monitorAmbientes.component';
import { MonitorDetalleDisponibilidadComponent } from './components/monitorDetalleDisponibilidad.component';

const appRoutes: Routes = [
    {path:'monitorAmbientes', component: MonitorAmbientesComponent},
    {path:'monitorDetalleDisponibilidad', component: MonitorDetalleDisponibilidadComponent},
	{path:'**', component: MonitorAmbientesComponent}
];

export const appRoutingProviders :any[] = [];
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);