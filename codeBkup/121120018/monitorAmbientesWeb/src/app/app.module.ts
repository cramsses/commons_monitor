import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BoundSensorModule } from 'angular-bound-sensor';

//Configuración del Routing:
import { routing, appRoutingProviders } from './app.routing';

//Importación de librería para las gráficas:
import { Ng2GoogleChartsModule } from 'ng2-google-charts';

//Importación de cliente para servicios REST:
import { HttpClientModule } from '@angular/common/http';

//Componentes:
import { AppComponent } from './app.component';
import { MonitorAmbientesComponent } from './components/monitorAmbientes.component';
import { MonitorDetalleDisponibilidadComponent } from './components/monitorDetalleDisponibilidad.component';

//Servicios:
import { MonitorAmbientesService } from './services/monitorAmbientes.service';
import { AmbientesService } from './services/ambientes.service';
import { ServiciosAdicionalesService } from './services/serviciosAdicionales.service';
import { MonitorDetalleDisponibilidadService } from './services/monitorDetalleDisponibilidad.service';


@NgModule({
  declarations: [
    AppComponent,
    MonitorAmbientesComponent,
    MonitorDetalleDisponibilidadComponent 
  ],
  imports: [
    BrowserModule,
    Ng2GoogleChartsModule,
    routing,
    HttpClientModule,
    BoundSensorModule
  ],
  providers: [
    appRoutingProviders,
    MonitorAmbientesService,
    AmbientesService,
    ServiciosAdicionalesService,
    MonitorDetalleDisponibilidadService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
