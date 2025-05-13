import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import { provideAnimations } from '@angular/platform-browser/animations';

import { PrimeNGConfig, MessageService } from 'primeng/api';
import { provideHttpClient } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideAnimations(),
    provideHttpClient(),
    MessageService,
    {
      provide: PrimeNGConfig,
      useFactory: () => {
        const config = new PrimeNGConfig();

        config.ripple = true;
        config.zIndex = {
          modal: 1100,      
          overlay: 1000,    
          menu: 1000,       
          tooltip: 1100     
        };

        config.setTranslation({
          accept: 'Aceitar',
          reject: 'Rejeitar',

        });

        return config;
      }
    }
  ]
};