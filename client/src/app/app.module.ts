import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { MainComponent } from './main/main.component';
import { FooterComponent } from './footer/footer.component';
import { SearchComponent } from './search/search.component';
import { ListComponent } from './list/list.component';
import { ContactComponent } from './contact/contact.component';
import { ContactService } from './contact.service';
import { WrapperService } from './wrapper.service';
import { DefaultComponent } from './default/default.component';
import { ShowComponent } from './show/show.component';
import { AddComponent } from './add/add.component';
import { EditComponent } from './edit/edit.component';
import { GlobalService } from './global.service';
import { SearchPipe } from './search.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    MainComponent,
    FooterComponent,
    SearchComponent,
    ListComponent,
    ContactComponent,
    DefaultComponent,
    ShowComponent,
    AddComponent,
    EditComponent,
    SearchPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule.withConfig({ warnOnNgModelWithFormControl: 'never' }),
    AppRoutingModule
  ],
  providers: [
    ContactService,
    GlobalService,
    WrapperService],
  bootstrap: [AppComponent]
})
export class AppModule { }
