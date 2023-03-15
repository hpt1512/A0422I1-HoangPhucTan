import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import {HttpClientModule} from "@angular/common/http";
import { GeneralsListComponent } from './component/generals/generals-list/generals-list.component';
import { GeneralsCreateComponent } from './component/generals/generals-create/generals-create.component';
import { GeneralsUpdateComponent } from './component/generals/generals-update/generals-update.component';
import {ReactiveFormsModule} from "@angular/forms";
import {ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { LoHangListComponent } from './component/lo-hang/lo-hang-list/lo-hang-list.component';
import { LoHangCreateComponent } from './component/lo-hang/lo-hang-create/lo-hang-create.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    GeneralsListComponent,
    GeneralsCreateComponent,
    GeneralsUpdateComponent,
    LoHangListComponent,
    LoHangCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
