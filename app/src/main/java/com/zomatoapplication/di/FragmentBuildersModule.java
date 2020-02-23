package com.zomatoapplication.di;

import com.zomatoapplication.view.ui.DataListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract DataListFragment contributeProjectListFragment();
}
