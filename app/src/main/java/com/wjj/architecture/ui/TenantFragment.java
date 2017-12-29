package com.wjj.architecture.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wjj.architecture.R;
import com.wjj.architecture.entity.Tenant;
import com.wjj.architecture.viewmodel.TenantListViewModel;

import java.util.List;


public class TenantFragment extends Fragment {
    private static final String TENANT_ID = "tenant_id";
    public static String TAG = "TenantFragmentTag";
    private String tenantId;
    private TenantListViewModel tenantViewModel;

    public TenantFragment() {
    }

    public static TenantFragment newInstance(String tenantId) {
        TenantFragment fragment = new TenantFragment();
        Bundle args = new Bundle();
        args.putString(TENANT_ID, tenantId);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tenant, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            tenantId = getArguments().getString(TENANT_ID);
        }
        tenantViewModel = ViewModelProviders.of(this).get(TenantListViewModel.class);
        tenantViewModel.getTenantList().observe(this, new Observer<List<Tenant>>() {
            @Override
            public void onChanged(@Nullable List<Tenant> tenants) {
                //Room/WebService → ViewModel → View(Activity/Fragment)

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
